window.onload = () => {
  new Vue({
    el: '#app',
    mixins: [mixin],
    data() {
      return {
        checkedAll: false,
        shopCartList: [],
        totalPrice: 0,
        checkedIdList: []
      }
    },
    filters: {
      formatPrice (num) {
        return num.toFixed(2)
      }
    },
    methods: {
      _removeId (id) {
        const index = this.checkedIdList.indexOf(id)
        if (index > -1) {
          this.checkedIdList.splice(index, 1)
        }
      },
      sub (index) {
        if (this.shopCartList[index].num === 0) return
        if (this.shopCartList[index].checked) {
          this.totalPrice -= this.shopCartList[index].inPrice
        }
        this.shopCartList[index].num --
      },
      add (index) {
        if (this.shopCartList[index].checked) {
          this.totalPrice += Number(this.shopCartList[index].inPrice)
        }
        this.shopCartList[index].num ++
      },
      check(item) {
        if (!item.checked) {
          this.checkedAll = false
          this.totalPrice -= item.inPrice * item.num
          this._removeId(item.id)
          return
        }
        this.checkedIdList.push(item.id)
        this.totalPrice += item.inPrice * item.num
        let isCheckAll = this.shopCartList.every((item) => {
          return item.checked === true
        })
        if (isCheckAll) {
          this.checkedAll = true
        }
      },
      checkAll() {
        this.totalPrice = 0
        this.checkedIdList = []
        if (this.checkedAll) {
          this.shopCartList.forEach((item) => {
            item.checked = true
            this.totalPrice += item.num * item.inPrice
            this.checkedIdList.push(item.id)
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
              this.totalPrice = 0
              this.checkedAll = false
              this.shopCartList = result.goodsList.map((item => {
                item.checked = false
                return item
              }))
            }
          })
      },
      deleteGood(carid) {
          swal({
            title: "确认删除？",
            text: "此操作将永久删除商品",
            icon: "warning",
            buttons: ["取消", "确认"],
            dangerMode: true,
          }).then((willDelete) => {
            if(willDelete) {
              const isArray = Array.isArray(carid)
              let idlist = null
              if (isArray) {
                idlist = this.checkedIdList.map(item => {
                  return { carid: item }
                })
              } else {
                idlist = [{ carid }]
              }
              axios({
                method: 'POST',
                url: '/Furniture/DeleteShoppingCart',
                data: Qs.stringify({ id: this.userId, idlist })
              })
                .then(({ data }) => {
                  const { result, code } = data
                  if (code === 200) {
                    sweetAlert("Yes", "删除成功！", "success");
                    this.fetchData(this.userId)
                  } else {
                    sweetAlert("Oops..", "删除失败", "error");
                  }
                })
            } else {
              swal("Oops..", "已取消删除", "error");
            }
          });
      },
      likeGood (item) {
        axios({
          method: 'POST',
          url: '/Furniture/movetoCollect',
          data: Qs.stringify({ id: this.userId, carid: item.id, goodsid:item.goodsid })
        })
          .then(({ data }) => {
            const {code, result} = data
            if (code === 200) {
              sweetAlert("Yes", "成功添加至收藏夹！", "success");
            } else {
              sweetAlert("Oops..", "无法添加至收藏夹，请重试！", "error");
            }
          })
          .catch((err) => {
            console.log(err)
          })
      },
      settlement () {
        if (this.totalPrice === 0) {
          sweetAlert("Oops..", "请选择商品进行结算", "error");
          return
        }
        const buyList = this.shopCartList.map((item) => {
          if (item.checked) {
            return item
          }
        })
        window.localStorage.setItem('buy-list', JSON.stringify(buyList))
        window.location.href = "orderbuy.html"
      }
    },
    created() {
      this.fetchData(this.userId)
    }
  })
}