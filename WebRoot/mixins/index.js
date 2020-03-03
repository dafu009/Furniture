const mixin = {
  data () {
    return {
      isLogin: window.sessionStorage.getItem('userId') ? true : false,
      userId: window.sessionStorage.getItem('userId'),
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
      // 退出登录
    },
    goLike () {
      window.location.href = 'like.html'
    },
    goShopCart () {
      window.location.href = 'shoppingcart.html'
    },
    goMyOrder () {
      window.location.href = 'myorder.html'
    }
  }
} 