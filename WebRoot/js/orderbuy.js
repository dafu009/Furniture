window.onload = () => {
  new Vue({
    el: '#app',
    mixins: [mixin],
    data () {
      return {
        buyList: JSON.parse(window.localStorage.getItem('buy-list'))
      }
    },
    methods: {
      submit () {
        swal({
          title: "确认提交吗?",
          text: "此操作将进行订单提交",
          icon: "warning",
          buttons: ["取消", "确认"],
          dangerMode: true,
        })
          .then(willDone => {
            if (willDone) {
              axios({
                method: 'POST',
                url: '/Furniture/addOrder',
                data: Qs.stringify({ id: this.userId, idlist: this.buyList })
              })
                .then(({ data }) => {
                  const { code } = data
                  if (code === 200) {
                    sweetAlert("Yes", "提交成功！", "success")
                    window.location.href = 'orderbuy_yes.html'
                  }
                })
            } else {
              swal("Oops", "已取消", "error");
            }
          })
      }
    },
    created () {

    }
  })
}