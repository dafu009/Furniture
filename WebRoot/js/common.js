function getUrlParam (name) {
  const reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)')
  const rst = window.location.search.substr(1).match(reg)
  if (rst) return decodeURI(rst[2])
  return null
}
/* 顶部及导航条 */
window.onload = () => {
  const app = new Vue({
	el: '#app',
    data () {
      return {
        isLogin: null,
        searchText: '',
        offsetTop: 0,
        isFixed: false,
        currentCategory: {},　// 当前类别的物品
        currentIndex: 0,  // 当前nav索引
        goodId: null,
        goodDetail: {},
        nav: [
          {
            title: '所有产品',
            categoryId: 111,
          },
          {
            title: '储物收纳',
            categoryId: 222,
          },
          {
            title: '厨房用具',
            categoryId: 333,
          },
          {
            title: '餐具',
            categoryId: 444,
          },
          {
            title: '装饰品',
            categoryId: 555,
          },
          {
            title: '萌宠爱物',
            categoryId: 666,
          },
          {
            title: '灯具',
            categoryId: 777,
          },
          {
            title: '玩耍和玩具',
            categoryId: 333,
          }
        ], 
      }
    },
    methods: {         
      current (index) {
        this.currentIndex = index
        this.currentCategory.title = this.nav[index].title
        axios({ // ajax 请求
          method: 'GET',　// 具体看请求后端的方式
          url: '', // 后端查询接口
          data: {
            firstName: 'Fred',
            lastName: 'Flintstone'
          }
        })
          .then(({ code, result }) => {
            if (code === 200) {
              // data为后端返回的数据 对物品列表进行赋值
              this.currentCategory.title = this.nav[index].title
              this.currentCategory.list = result
            }
          })
          .catch((err) => {
            console.log(err)
          })
      },
      goGoodDetail (id) {
        // 点击，跳转到相应的产品详情页
        location.href = `/goodsdetail.html?goodsId=${id}`
      },
      goCategoryDetail (id) {
        // 点击，跳转到相应的产品分类页面
        location.href = `/goodsType.html?categoryID=${id}`
      },
      searchData () {
        setCookie("SearchTxt", this.searchData)
        location.href = "/searchList.html?keywords=" + this.searchData
      },
      handleScroll () {
        let scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
        this.isFixed = scrollTop > this.offsetTop ? true : false;
      },
      toRegister () {
        // 去注册
    	 location.href = "../WEB-INF/content/register.html"
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
      //
      queryGoodDetail (id) {
          axios({
            method: 'post',
            data: {
              goodId: id
            },
            url: ''
          })
            .then(({ code, result }) => {
              if (code === 200) {
                this.goodDetail = result
              }
            })
            .catch(err => {
              console.log(err)
            })
        },
        addFavorite () {
          // 收藏 利用goodId
        },
        addShoppingCart () {
          // 加入购物车 利用goodId
        },
        buyNow () {
          // 立即购买 利用goodId
        }
    },
    created () {
      this.isLogin = window.sessionStorage.getItem('userId') ? true : false
      this.goodId = Number(getUrlParam('goodId')) || 0
    },
    mounted () {
      window.addEventListener('scroll', this.handleScroll)
      this.$nextTick(() => {
        this.offsetTop = document.querySelector('#nav').offsetTop
      })
    },
    destroyed () {
      window.removeEventListener('scroll', this.handleScroll);
    }
  }).$mount('#app')
}