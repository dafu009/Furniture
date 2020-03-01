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
        totalList: [],
        loadMoreShow: true,
        currentCategory: {
          id: null,
          list: [],
          title: '',
          total: 0,
          page: {
            num: 1,
            size: 8
          }
        },　// 当前类别的物品
        currentIndex: 0,  // 当前nav索引
        goodId: null,
        goodDetail: {},
        nav: [
          {
            title: '当前产品',
            categoryId: 0,
          },
          {
            title: '储物收纳',
            categoryId: 1,
          },
          {
            title: '厨房用具',
            categoryId: 3,
          },
          {
            title: '餐具',
            categoryId: 4,
          },
          {
            title: '装饰品',
            categoryId: 5,
          },
          {
            title: '萌宠爱物',
            categoryId: 6,
          },
          {
            title: '灯具',
            categoryId: 7,
          },
          {
            title: '玩耍和玩具',
            categoryId: 8,
          }
        ], 
      }
    },
    methods: {
      current (index, id) {
        this.currentIndex = index
        this.currentCategory.title = this.nav[index].title
        this.currentCategory.page.num = 1
        this.currentCategory.id = id
        this.totalList = []
        this.loadMoreShow = true
        let params = {
          id,
          page: this.currentCategory.page.num,
          pageSize: this.currentCategory.page.size
        }
        if (index === 0) return
        this.fetchData(params)
      },
      concatList () {
        this.totalList = this.totalList.concat(this.currentCategory.list)
      },
      fetchData (params) {
        axios({ // ajax 请求
          method: 'GET',　// 具体看请求后端的方式
          url: '/Furniture/goodsTypeDetail', // 后端查询接口
          params
        })
          .then(({ data }) => {
            const { code, result, state } = data
            if (code === 200) {
              if (result.bookList.length === 0) {
                this.loadMoreShow = false
                return
              }
              this.currentCategory.list = result.bookList
              this.currentCategory.total = result.nCount
              this.concatList()
            }
          })
          .catch((err) => {
            console.log(err)
          })
      },
      loadMore() {
        let params = {
          id: this.currentCategory.id,
          page: ++ this.currentCategory.page.num,
          pageSize: this.currentCategory.page.size
        }
        this.fetchData(params)
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
    	 location.href = "/Furniture/register.html"
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
      //产品详情信息
      queryGoodDetail (id) {
          axios({
            method: 'GET',
            url: '/Furniture/getgoodsDetail',
            params: {
              id
            }
          })
            .then(({ data }) => {
              const { code, result } = data
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
      this.goodId = Number(getUrlParam('goodsId')) || 0
      this.queryGoodDetail(this.goodId)
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