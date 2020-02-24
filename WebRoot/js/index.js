// function getTopHtml (index) {
//   console.log(index)
//   $(".nav_box .b" + index).addClass("on");
//   getplaceholder("txtNavSearch", "请输入关键词");
//   $("#txtNavSearch").keydown(function (e) {
//     if (e.keyCode == 13) {
//       searchData();
//     }
//   });

//   //顶部菜单选择
//   var nownav = "";
//   $(".top_div .nav_box_all .nav_box .box").mouseenter(function () {
//     $(".nav_two_all").stop(true, false).slideUp(300);
//     nownav = $(this).attr("navid");
//     if (nownav == 2) {
//       $("#nav_two" + nownav).slideDown(300);
//     } else {
//       $(".nav_two_all").stop(true, false).slideUp(300);
//     }
//   });
//   $(".top_div .nav_box_all").mouseleave(function () {
//     $(".nav_two_all").stop(true, false).slideUp(300);
//   });
// }

window.onload = () => {
  const app = new Vue({
    data () {
      return {
        searchText: '',
        nav: [
          '所有产品',
          '储物收纳',
          '厨房用具',
          '餐具',
          '装饰品',
          '萌宠爱物',
          '灯具',
          '玩耍和玩具'
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
        ],
        currentIndex: 0
      }
    },
    methods: {
      current (index) {
        this.currentIndex = index
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
      }
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
