window.onload = () => {
  const vm = new Vue({
    el: '#app',
    data () {
      return {
        params: {
          username: '',
          password: ''
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
        if (!this.params.password) {
          sweetAlert('Oops..', '请输入密码', 'error')
          this.$refs.password.focus()
          return
        }
        axios({
          method: 'post',
          datatype: 'json',
          url: loginfunc_url,
          data: this.params
        })
          .then(({ code, message, result }) => {
            if (code === 200) {
              if (result.flag == 1) {
                sessionStorage.setItem('userId', result.id);
                sessionStorage.setItem('username', result.username);
                window.location.href = 'index.html';
              } else {
                sweetAlert('Sorry..', result.message, 'error');
              }
            }
            else {
              sweetAlert('Oops..', message, 'error');
            }
          })
          .catch((err) => {
            console.log(err)
          })
      }
    }
  })
}