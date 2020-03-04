window.onload = () => {
  new Vue({
    el: '#app',
    mixins: [mixin],
    data () {
      return {
        likeList: []
      }
    },
    methods: {
      cancelLike (likeid) {
        swal({
          title: "确认取消收藏吗？",
          icon: "warning",
          buttons: ["取消", "确认"],
          dangerMode: true,
        })
          .then(willCancel => {
            if (willCancel) {
              axios({
                method: 'POST',
                url: '/Furniture/DeletelCollect',
                data: Qs.stringify({ id: this.userId, idlist: [{ likeid }] })
              })
                .then(({ data }) => {
                  this.fetchData()
                })
            }
          })

      },
      fetchData () {
        axios({
          method: 'POST',
          url: '/Furniture/getcollect',
          data: Qs.stringify({ id: this.userId })
        })
          .then(({ data }) => {
            console.log(data)
            const { code, result } = data
            if (code === 200) {
              this.likeList = result.goodsList
            }
          })
      },
      addShopCart (goodsid) {
        axios({
          method: 'POST',
          url: '/Furniture/addLikeCart',
          data: Qs.stringify({
            id: this.userId,
            sign: 1,
            goodsid
          })
        })
          .then(({ data }) => {
            const { code } = data
            if (code === 200) {
              sweetAlert("Yes", "添加购物车成功!", "success");
            } else {
              sweetAlert("Oops..", "添加购物车失败!", "error");
            }
          })
      },
      goGoodDetail (id) {
        // 点击，跳转到相应的产品详情页
        window.location.href = `goodsdetail.html?goodsId=${id}`
      }
    },
    created () {
      this.fetchData()
    }
  })
}