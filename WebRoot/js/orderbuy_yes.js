window.onload = () => {
  new Vue({
    el: '#app',
    mixins: [mixin],
    data () {
      return {
        recommendList: []
      }
    },
    created () {
      this.getRecommendList()
    },
    methods: {
      goGoodDetail(id) {
        // 点击，跳转到相应的产品详情页
        window.location.href = `goodsdetail.html?goodsId=${id}`
      },
      getRecommendList() {
        axios({
          method: 'POST',
          url: '/Furniture/getRecommendGoodsLike',
          data: Qs.stringify({
            userid: this.userId,
            page: 1,
            pageSize: 10
          })
        })
          .then(({data}) => {
            const {code, result} = data
            if (code === 200) {
              this.recommendList = result.GoodsList
            }
          })
      }
    }
  })
}