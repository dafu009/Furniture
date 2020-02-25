function getUrlParam (name) {
  const reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)')
  const rst = window.location.search.substr(1).match(reg)
  if (rst) return decodeURI(rst[2])
  return null
}
window.onload = () => {
  const vm = new Vue({
    el: '#app',
    data () {
      return {
        goodId: null,
        goodDetail: {}
      }
    },
    methods: {
      queryGoodDetail (id) {
        axios({
          method: 'post',
          data: {
            goodId: id
          },
          url: ''
        })
          .then(({ code, result }) => {
            if (code === 200) {
              this.goodDetail = result
            }
          })
          .catch(err => {
            console.log(err)
          })
      },
      addFavorite () {
        // 收藏 利用goodId
      },
      addShoppingCart () {
        // 加入购物车 利用goodId
      },
      buyNow () {
        // 立即购买 利用goodId
      }
    },
    created () {
      this.goodId = Number(getUrlParam('goodId')) || 0
    }
  })
}
