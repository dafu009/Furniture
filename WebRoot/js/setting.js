window.onload = () => {
  new Vue({
    el: '#app',
    mixins: [mixin],
    data () {
      return {
        labelWidth: '80px',
        dialogShow: false,
        userInfo: {},
        password: {
          oldPass: '',
          newPass: '',
          repeatPass: ''
        }
      }
    },
    methods: {
      update () {
        axios({
          method: 'POST',
          url: '/Furniture/userSelfReset',
          data: Qs.stringify({
            id: this.userId,
            username: this.username,
            addr: this.userInfo.addr,
            phone: this.userInfo.phone
          })
        })
          .then(({data}) => {
            const { code } = data
            if (code === 200) {
              this.message('修改成功', 'success')
            } else {
              this.message('修改失败请重试', 'error')
            }
          })
      },
      message (message, type) {
        this.$message({
          message,
          type
        })
      },
      resetPassword () {
        if (!this.password.oldPass) {
          this.message('请输入原密码', 'error')
          return
        }
        if (!this.password.newPass) {
          this.message('请输入新密码', 'error')
          return
        }
        if (!this.password.repeatPass) {
          this.message('请重复确认密码', 'error')
          return
        }
        if (this.password.newPass !== this.password.repeatPass) {
          this.message('密码不一致，请重新输入', 'error')
          return
        }
        axios({
          method: 'POST',
          url: '/Furniture/userPwdReset',
          data: Qs.stringify({
            id: this.userId,
            oldpwd: this.password.oldPass,
            newpwd: this.password.newPass
          })
        })
          .then(({ data }) => {
            const { code } = data
            if (code === 200) {
              this.dialogShow = false
              this.message('修改成功', 'success')
            } else {
              this.message('修改失败', 'error')
            }
          })
      },
      getUserInfo () {
        axios({
          method: 'POST',
          url: '/Furniture/userSelf',
          data: Qs.stringify({ id: this.userId })
        })
          .then(({ data }) => {
            const {code, result} = data
            if (code === 200) {
              this.userInfo = result
            }
          })
      }
    },
    created () {
      this.getUserInfo()
    }
  })
}