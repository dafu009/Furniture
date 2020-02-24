window.onload = () => {
  const app = new Vue({
    data () {
      return {
        isLogin: null,
        searchText: '',
        offsetTop: 0,
        isFixed: false,
        currentCategoryList: [],　// 当前类别的物品列表
        currentIndex: 0,  // 当前nav索引
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
          { id: 5 }, { id: 6 }, { id: 7 }
        ],
        leisureGoods: [
          { id: 8 }, { id: 9 }, { id: 10 }, { id: 11 }, { id: 12 }, { id: 13 }
        ],
        workGoods: [
          { id: 14 }, { id: 15 }
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
      current (index) {
        this.currentIndex = index
        axios({ // ajax 请求
          methods: 'GET',　// 具体看请求后端的方式
          url: '', // 后端查询接口
          data: {
            firstName: 'Fred',
            lastName: 'Flintstone'
          }
        })
          .then((data) => {
            // data为后端返回的数据 对物品列表进行赋值
            this.currentCategoryList = data
          })
          .catch((err) => {
            console.log(err)
          })
      },
      goGoodDetail (id) {
        // do something
      },
      goCategoryDetail (id) {
        // do something
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
      },
      toSelfPage () {
        // 去个人中心
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
