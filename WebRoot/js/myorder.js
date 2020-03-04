window.onload = () => {
  new Vue({
    el: '#app',
    mixins: [mixin],
    data() {
      return {
        orderList: []
      }
    },
    computed: {
      totalPrice () {
        let total = 0
        this.orderList.forEach(item => {
          total += Number(item.totalMoney)
        })
        return total || 0
      }
    },
    methods: {
      fetchData () {
        axios({
          method: 'POST',
          url: '/Furniture/viewOrder',
          data: Qs.stringify({ id: this.userId })
        })
          .then(({ data }) => {
            const {code, result} = data
            if (code === 200) {
              this.orderList = result.orderlist
            }
          })
      }
    },
    created () {
      this.fetchData()
    }
  })
}