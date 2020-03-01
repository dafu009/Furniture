window.onload = () => {
  const vm = new Vue({
    el: '#app',
    data () {
      return {
        params: {
          username: '',
          pwd: ''
        }
      }
    },
    methods: {
      ToHomePage () {
        window.location.href = "index.html"
      },
      submit () {
        if (!this.params.username) {
          sweetAlert('Oops..', '请输入用户名', 'error')
          this.$refs.username.focus()
          return
        }
        if (!this.params.pwd) {
          sweetAlert('Oops..', '请输入密码', 'error')
          this.$refs.password.focus()
          return
        }
        axios({
          method: 'POST',
          url: '/Furniture/userLogin',
          data: Qs.stringify(this.params),
          // dataType: 'json',
          // headers: {
          //   'content-type': 'application/x-www-form-urlencoded'
          // }
        })
          .then(({ data }) => {
            const { code, flag, result } = data
            if (code === 200) {
              if (result.flag == 1) {
                sessionStorage.setItem('userId', result.id);
                sessionStorage.setItem('username', result.username);
                window.location.href = 'index.html';
              } else {
                sweetAlert('Sorry..', result.message, 'error');
              }
            } else {
              sweetAlert('Sorry..', '账号或密码有误，请重试', 'error');
            }
          })
          .catch((err) => {
            console.log(err)
          })
      }
    }
  })
}