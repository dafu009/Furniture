/* 顶部及导航条 */
window.onload = () => {
  const app = new Vue({
    data () {
      return {
        isLogin: null,
        searchText: '',
        offsetTop: 0,
        isFixed: false,
        currentCategory: {},　// 当前类别的物品
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
}