const mixin = {
  data () {
    return {
      isLogin: window.sessionStorage.getItem('userId') ? true : false,
      userId: window.sessionStorage.getItem('userId'),
      recommendList: []
    }
  },
  methods: {
    toHomePage () {
      window.location.href = 'index.html'
    },
    toRegister () {
      // 去注册
      window.location.href = 'register.html'
    },
    toSelfPage () {
      // 去个人中心
      if (this.isLogin) {
        window.location.href = 'setting.html'
      } else {
        window.location.href = 'login.html'
      }
    },
    quit () {
      swal({
        title: "是否确认退出?",
        icon: "warning",
        buttons: ["取消", "确认"],
        dangerMode: true,
      })
        .then(willQuit => {
          if (willQuit) {
            window.sessionStorage.removeItem("userId")
            window.sessionStorage.removeItem("username")
            window.location.href = 'index.html'
          }
        })
      // 退出登录
    },
    goLike () {
      if (this.isLogin) {
        window.location.href = 'like.html'
      } else {
        window.location.href = 'login.html'
      }
    },
    goShopCart () {
      if (this.isLogin) {
        window.location.href = 'shoppingcart.html'
      } else {
        window.location.href = 'login.html'
      }
    },
    goMyOrder () {
      if (this.isLogin) {
        window.location.href = 'myorder.html'
      } else {
        window.location.href = 'login.html'
      }
    }
  }
} 