window.onload = () => {
  const vm = new Vue({
    el: '#app',
    data () {
      return {
        username: '',
        telephone: '',
        address: '',
        password: '',
        checkpass: ''
      }
    },
    methods: {
      goHomePage () {
        window.location.href = "index.html"
      },
      resister () {
        if (!this.username) {
          sweetAlert('Oops..', '请输入用户名', 'error')
          return
        }
        if (!this.telephone || !this.address) {
          sweetAlert('Oops..', '请输入完整信息', 'error')
          return
        }
        if (!this.password) {
          sweetAlert('Oops..', '请输入密码', 'error')
          return
        }
        if (!this.checkpass) {
          sweetAlert('Oops..', '请输入确认密码', 'error')
          return
        }
        if (this.checkpass !== this.password) {
          sweetAlert('Oops..', '密码不一致请重新输入', 'error')
          this.checkpass = ''
          this.password = ''
          return
        }
        // 注册的请求
        axios({
          method: 'post',
          data: {
            username: this.username,
            password: this.password
          },
          url: '' // 注册api
        })
          .then(({ code, result }) => {
            // 注册成功的返回　=> 可跳转登录页或者直接登录
          })
          .catch((err) => {
            console.log(err)
          })
      }
    }
  })
}