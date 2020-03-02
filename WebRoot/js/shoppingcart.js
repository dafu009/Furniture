window.onload = () => {
  new Vue({
    el: '#app',
    data() {
      return {
        isLogin: window.sessionStorage.getItem('userId') ? true : false,
        userId: window.sessionStorage.getItem('userId'),
        checkedAll: false,
        shopCartList: []
      }
    },
    methods: {
      toSelfPage() {
      },
      quit() {
      },
      toRegister() {
      },
      alertMuch() {
      },
      saveData() {
      },
      check(item) {
        if (!item.checked) {
          this.checkedAll = false
          return
        }
        let isCheckAll = this.shopCartList.every((item) => {
          return item.checked === true
        })
        if (isCheckAll) {
          this.checkedAll = true
        }
      },
      checkAll() {
        if (this.checkedAll) {
          this.shopCartList.forEach((item) => {
            item.checked = true
          })
        } else {
          this.shopCartList.forEach((item) => {
            item.checked = false
          })
        }
      },
      fetchData(id) {
        axios({
          method: 'POST',
          url: '/Furniture/getshoppingCart',
          data: Qs.stringify({id})
        })
          .then(({data}) => {
            const {result, code} = data
            if (code === 200) {
              // console.log(result)
              this.shopCartList = result.goodsList.map((item => {
                item.checked = false
                return item
              }))
            }
          })
      },
      deleteGood(carid) {
        axios({
          method: 'POST',
          url: '/Furniture/DeleteShoppingCart',
          data: Qs.stringify({id: this.userId, idlist: [{carid}]})
        })
          .then(data => {
            console.log(data)
          })
      }
    },
    created() {
      this.fetchData(this.userId)
    }
  })
}