window.onload = () => {
  const app = new Vue({
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
        nav: [
          {
            title: '所有产品',
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
        clearGoods: [
          {
            name: '拖把',
            id: 1
          },
          {
            name: '刷子',
            id: 2
          },
          {
            name: '皂液器',
            id: 3
          },
          {
            name: '洗衣篮',
            id: 4
          }
        ],
        admissionGoods: [
          {
            name: 'kitchen',
            id: 5
          },
          {
            name: 'shouna',
            id: 6
          },
          {
            name: 'cloth',
            id: 7
          }
        ],
        leisureGoods: [
          {
            name: 'toe',
            id: 8
          },
          {
            name: 'bed',
            id: 9
          },
          {
            name: 'green',
            id: 10
          },
          {
            name: 'gym',
            id: 11
          },
          {
            name: 'sofa',
            id: 12
          }
        ],
        workGoods: [
          {
            name: 'big',
            id: 13
          },
          {
            name: 'small',
            id: 14
          }
        ],
        hotCategorys: [
          {
            id: 1,
            name: '储物'
          },
          { id: 2 },
          { id: 3 },
          { id: 4 },
          { id: 5 },
          { id: 6 },
          { id: 7 },
          { id: 8 },
          { id: 9 },
          { id: 10 }
        ]
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
        this.fetchData(params)
      },
      loadMore() {
        let params = {
          id: this.currentCategory.id,
          page: ++ this.currentCategory.page.num,
          pageSize: this.currentCategory.page.size
        }
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
    },
    created () {
      this.isLogin = window.sessionStorage.getItem('userId') ? true : false
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
  //轮播图
  const mySwiper = new Swiper('#swiper-container-id1', {
    autoplay: true,
    autoplay: 5000,
    loop: true,
    pagination: '.swiper-pagination',
    paginationClickable: true,
  })
}
