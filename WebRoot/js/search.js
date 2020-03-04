function getUrlParam (name) {
  const reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)')
  const rst = window.location.search.substr(1).match(reg)
  if (rst) return decodeURI(rst[2])
  return null
}
window.onload = () => {
  new Vue({
    el: '#app',
    mixins: [mixin],
    data () {
      return {
        page: 1,
        pageSize: 8,
        result: [],
        searchText: '',
        total: 0
      }
    },
    created () {
     this.searchText = getUrlParam('keywords') || ''
      console.log(this.searchText)
      if (this.searchText) {
        this.searchData()
      }
    },
    methods: {
      searchData () {
        axios({
          method: 'POST',
          url: '/Furniture/getsearchGoods',
          data: Qs.stringify({ page: this.page, pageSize: this.pageSize, content: this.searchText })
        })
          .then(({data}) => {
            const { code, result } = data
            if (code === 200) {
              this.total = result.nCount
              this.result = result.goodsList
            }
          })
      },
      goGoodDetail (id) {
        // 点击，跳转到相应的产品详情页
        window.location.href = `goodsdetail.html?goodsId=${id}`
      },
      buyNow (good) {
        good.num = 1
        good.goodsid = good.id
        delete good.id
        window.localStorage.removeItem('buy-list')
        window.localStorage.setItem('buy-list', JSON.stringify([good]))
        window.location.href = "orderbuy.html"
      },
      addCartOrLike (goodsid, sign) {
        let txt = sign ? '购物车' : '收藏夹'
        axios({
          method: 'POST',
          url: '/Furniture/addLikeCart',
          data: Qs.stringify({
            id: this.userId,
            sign,
            goodsid
          })
        })
          .then(({ data }) => {
            const { code, result } = data
            if (result.isExist) {
              sweetAlert("Oops..", "物品已收藏~", "warning");
              return
            }
            if (code === 200) {
              sweetAlert("Yes", `添加${txt}成功!`, "success");
            } else {
              sweetAlert("Oops..", `添加${txt}失败!`, "error");
            }
          })
      }
    }
  })
}