/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : furniture

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2020-02-15 23:36:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(255) DEFAULT NULL,
  `parentID` bigint(20) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '储物', '0', null);
INSERT INTO `category` VALUES ('2', '纺织品', '0', null);
INSERT INTO `category` VALUES ('3', '厨具', '0', null);
INSERT INTO `category` VALUES ('4', '餐具', '0', null);
INSERT INTO `category` VALUES ('5', '装饰品', '0', null);
INSERT INTO `category` VALUES ('6', '宠物', '0', null);
INSERT INTO `category` VALUES ('7', '灯具', '0', null);
INSERT INTO `category` VALUES ('8', '玩耍和玩具', '0', null);
INSERT INTO `category` VALUES ('9', '浴室镜', '0', null);
INSERT INTO `category` VALUES ('10', '休闲和安全产品', '0', null);

-- ----------------------------
-- Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userID` varchar(255) DEFAULT NULL,
  `goodsID` varchar(255) DEFAULT NULL,
  `collectDate` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(255) DEFAULT NULL,
  `categoryID` varchar(255) DEFAULT NULL,
  `picInfo` longtext,
  `inPrice` varchar(255) DEFAULT NULL,
  `quantity` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'SOCKERBIT 索克比', '1', '../img/XQ11.jpg', '￥19.90', '100', '相比将所有物品装进一个大盒中，使用多个小盒子进行收纳能帮助你更好地整理小物品。 超级实用的小物件整理收纳工具，可存放兴趣用品和螺丝等。', '19x26x15 厘米', '储物盒, 浅蓝色', null);
INSERT INTO `goods` VALUES ('2', 'PUDDA 普达\r\nPUDDA 普达篮', '1', '../img/XQ12.jpg', '￥79.00', '100', '柔软的毛毡面料和闪亮的黄铜纽扣等细节，可以为任何储物空间增添时尚之感。这款篮子有两个尺寸，可以收纳不同大小的配饰，而且和 EKET 伊克特 储物装置搭配起来非常漂亮。', '28x28x23 厘米', '灰色', null);
INSERT INTO `goods` VALUES ('3', 'MOPPE 莫培', '1', '../img/XQ13.png', '￥99.90', '100', 'MOPPE 莫培 迷你抽屉柜配有多个抽屉，设计经典，风格永不过时。同样由未经处理的木材制成，你可以随心所欲地反复喷涂并进行装饰。这款产品能承载重物且经久耐用。', '31x18x32 厘米', '小型抽屉柜, 桦木胶合板', null);
INSERT INTO `goods` VALUES ('4', 'FJÄLLA 福佳', '1', '../img/XQ14.png', '￥39.90', '100', '设计经典，带有金属盒角、把手、标签匣等细节，便于你时尚美观地收纳整理物品。这款杂志盒可完美搭配其他 FJÄLLA 福佳 产品。', null, '文件盒, 白色', null);
INSERT INTO `goods` VALUES ('5', 'FJÄLLA 福佳', '1', '../img/XQ15.jpg', '￥29.90', '100', '储物盒尺寸较小，可以放在桌边或是衣柜里。设计经典，带有金属盒角、把手、标签匣等细节，便于你时尚美观地收纳整理物品。', '18x26x15 厘米', '附盖储物盒, 绿色, 花朵图案', null);
INSERT INTO `goods` VALUES ('6', 'SKUBB 思库布', '1', '../img/XQ16.png', '¥ 69.00', '100', '需要更多搁板来放置折叠的衣物？只需要把这款储物件挂在衣柜中或独立式衣架上就好了。你还可搭配其他 SKUBB 思库布 产品，完全掌控你的衣柜。', '35x45x125 厘米', '黑色', null);
INSERT INTO `goods` VALUES ('7', 'SKUBB 思库布', '1', '../img/XQ17.jpg', '¥ 59.00', '100', '网格设计方便鞋子通风，而且可以清楚地看到里面是哪一双鞋。你还可搭配其他 SKUBB 思库布 产品，完全掌控你的衣柜。', '22x34x16 厘米', '鞋盒, 白色/4个', null);
INSERT INTO `goods` VALUES ('8', 'SKÅDIS 斯考迪斯', '1', '../img/XQ18.png', '¥ 278.00', '100', '可放在家中任何地方收纳小物品，让它们触手可及，让空间井然有序。可以随意组合 SKÅDIS 斯考迪斯 洞洞板与同系列配件，或者选择已经搭配好的组合', '56x112 厘米', '小钉板组合, 木头', null);
INSERT INTO `goods` VALUES ('9', 'HEJNE 赫尼', '1', '../img/XQ19.png', '¥ 180.00', '100', 'HEJNE 赫尼 储物系列坚固结实，可收纳重物，适合放在车库、地下室或阁楼使用。可以保持实木未处理的状态，也可以按照喜好染色、喷漆、上蜡，彰显个性。', '78x31x131 厘米', '一段组合, 软木', null);
INSERT INTO `goods` VALUES ('10', 'EKET 伊克特', '1', '../img/XQ110.png', '¥ 1,740.00', '100', '使用 EKET 伊克特 装饰墙面。你可以用几个储物柜打造经典的储物方案，也可以想用多少就用多少，以令人意想不到的有趣方式组合，在满足需求的同时，让空间更具个人特色。', '175x35x210 厘米', '壁柜组合, 深灰色', null);
INSERT INTO `goods` VALUES ('11', 'EKET 伊克特', '1', '../img/XQ111.png', '¥ 699.00', '100', '有了 EKET 伊克特 系列，你可以尽情打造或大或小，或绚烂或朴实的展示或储物空间。当你的空间和需求发生变化时，你也能轻松调整 EKET 伊克特 解决方案。', '70x25x107 厘米', '带支脚橱柜组合, 白色, 仿白色橡木纹', null);
INSERT INTO `goods` VALUES ('12', 'KNIPSA 克尼萨', '1', '../img/XQ112.png', '¥ 149.00', '100', '非常适合存放报纸、照片或其他纪念品。 海草会自然变色，让每个篮筐皆与众不同。 这款储物盒可与 KALLAX 卡莱克 搁板完美搭配使用。', '32x33x32 厘米', '篮, 海草', null);
INSERT INTO `goods` VALUES ('13', 'KNAGGLIG 卡纳格', '1', '../img/XQ113.jpg', '¥ 99.00', '100', '这款盒子十分耐用，可以承载重物。你可以让它保持原样，也可以上油、打蜡或涂你喜欢的颜色。放在客厅或者车库都很漂亮，非常适合搭配 IVAR 伊娃 储物装置。', '46x31x25 厘米', '盒, 松木', null);
INSERT INTO `goods` VALUES ('14', 'RABBLA 雷布拉', '1', '../img/XQ114.jpg', '¥ 149.00', '120', '这款储物盒可以装饰衣柜内部或让你的开放式储物解决方案更具吸引力。这款柔软的布艺盒带木质竹盖，打造出温馨天然的风格，有多种尺寸可选。', '35x50x30 厘米', '附盖储物盒', null);
INSERT INTO `goods` VALUES ('15', 'VEDBÄK 维德贝克', '2', '../img/XQ2-1.png', '¥ 699.00', '121', '我们在这一精致的图案中增添了些许粉色，打造出充满经典东方特色，又不失清新美丽的外观造型。这款地毯可与多种风格轻松搭配，即便放在最热闹繁忙的空间内也能经得起时间考验。', '170x230 厘米', '短绒地毯, 多色', null);
INSERT INTO `goods` VALUES ('16', 'KINNEN 肯能', '2', '../img/XQ2-2.png', '¥ 69.00', '100', '图案生动又经典！这款柔软的棉/粘胶纤维混纺毛巾吸水性强，比普通的棉制毛巾干得更快。如果你喜欢黑白色调，可将此款毛巾与 KINNEN 肯能 浴帘搭配。', '70x140 厘米', '浴巾, 白色/黑色', null);
INSERT INTO `goods` VALUES ('17', 'MAJGULL 梅格尔', '2', '../img/XQ2-3.png', '¥ 399.00', '111', '遮光帘可保证睡觉时不受月光或街灯搅扰，想懒床时，也不会被阳光照醒。面料厚实，能够轻柔、均匀地垂落下来。', '145x250 厘米', '遮光窗帘，两幅, 深蓝色', null);
INSERT INTO `goods` VALUES ('18', 'GLUMSÖ 格鲁姆索', '2', '../img/XQ2-4.png', '¥ 799.00', '100', '生动的图案采用丝滑柔软的莱赛尔纤维织成，莱赛尔纤维是一种对环境影响特别小的天然材料。地毯具有耐磨、可再生、可降解的特点，可以轻松搭配任意房间风格。', '133x195 厘米', '平织地毯, 淡灰色', null);
INSERT INTO `goods` VALUES ('19', 'LEIKNY 雷克尼', '2', '../img/XQ2-5.jpg', '¥ 39.00', '100', '颜色鲜艳的花卉图案，在暗色背景之中，栩栩如生。LEIKNY 雷克尼 垫套搭配使用同种布料垫套的 EKTORP 爱克托 座椅相得益彰。', '50x50 厘米', '垫套, 黑色, 多色', null);
INSERT INTO `goods` VALUES ('20', 'ALPKLÖVER 奥普略福', '2', '../img/XQ2-6.png', '¥ 29.00', '100', 'ALPKLÖVER 奥普略福 垫套上交缠的藤蔓生动可爱，为你的床或沙发增添额外生机，令其焕然一新。由来自更可持续来源的100%棉制成，外观新颖，舒适加倍。', '50x50 厘米', '垫套, 自然色, 深绿色', null);
INSERT INTO `goods` VALUES ('21', 'ÅSATILDA 奥萨提达', '2', '../img/XQ2-7.png', '¥ 29.00', '100', '醒目的大波点图案能够为你的房间增添一抹清新色彩和舒适之感。ÅSATILDA 奥萨提达 垫套由来自更可持续来源的100%棉制成，令你爱不释手。', '50x50 厘米', null, null);
INSERT INTO `goods` VALUES ('22', 'SÖTHOLMEN 索特候姆', '2', '../img/XQ2-8.png', '¥ 129.00', '100', '使用 SÖTHOLMEN 索特候姆 垫套为户外空间增添色彩与个性。它由工艺精湛的手工艺人纯手工打造，采用更可持续的染色方式，颜色更持久。', '50x50 厘米', '垫套，室内/外, 深绿色', null);
INSERT INTO `goods` VALUES ('23', 'LOHALS 鲁哈斯', '2', '../img/XQ2-9.png', '¥ 599.00', '100', '黄麻是一种经久耐用的可再生材料，具有天然色差。', '160x230 厘米', '平织地毯, 自然色', null);
INSERT INTO `goods` VALUES ('24', 'AINA 艾纳', '2', '../img/XQ2-10.png', '¥ 399.00', '100', '亚麻布略有不规则的纹路，可让阳光从褶皱中透进来，也能提供隐秘性，为房间营造舒适光线和温暖感受。', '145x250 厘米', '窗帘，2幅, 深灰色', null);
INSERT INTO `goods` VALUES ('25', 'SKOGSKLÖVER 斯古斯拉芙', '2', '../img/XQ2-11.png', '¥ 199.00', '100', '独立的卷帘可遮挡外部光线，让室内更舒适。这款卷帘带阻尼，可缓慢卷起。不含线绳，不会给儿童带来危险。', '100x195 厘米', '卷帘, 白色', null);
INSERT INTO `goods` VALUES ('26', 'MAJGULL 梅格尔', '2', '../img/XQ2-12.png', '¥ 399.00', '111', '遮光帘可保证睡觉时不受月光或街灯搅扰，想懒床时，也不会被阳光照醒。面料厚实，能够轻柔、均匀地垂落下来。', '145x250 厘米', '遮光窗帘，两幅, 深蓝色', null);
INSERT INTO `goods` VALUES ('27', 'FILODENDRON 菲鲁登', '2', '../img/XQ2-13.jpg', '¥ 149.00 ', '100', '这里有一朵花，那里有一只蝴蝶——你总能在这一有趣图案中发现新乐趣。采用高纱支密度纯棉纺织而成，柔软亲肤。', '160x230 厘米', '被套和枕套, 深蓝色, 花卉图案', null);
INSERT INTO `goods` VALUES ('28', 'VÅRKRAGE 沃克洛格', '2', '../img/XQ2-14.png', '¥ 29.90', '22', null, '110x170 厘米', '休闲毯, 蓝色', null);
INSERT INTO `goods` VALUES ('29', 'FLODALEN 福鲁朵恩', '2', '../img/XQ2-15.png', '¥ 9.90', '100', '设计简洁，波状结构厚实，既亲肤舒适，又能给你的浴室添加一丝奢华之感。柔和松软，颜色百搭多样，你可从中选择最爱的款式。', '30x30 厘米', '小方巾, 淡紫色', null);
INSERT INTO `goods` VALUES ('30', 'SARALENA 萨拉列娜', '2', '../img/XQ2-16.png', '¥ 79.00', '100', '有趣的魔法花园颜色丰富，在深色柔软棉丝绒上特别显眼。背面和正面一样柔软，但是采用了和正面对比鲜明的色彩，打造不同风格。', '50x50 厘米', '靠垫, 黑色, 多色', null);
INSERT INTO `goods` VALUES ('31', 'SVULTEN 斯弗尔滕', '3', '../img/XQ3-1.png', '¥ 7.90', '111', '开口处较窄，便于往小罐中装填面粉、大米等干货，可防止洒落。\r\n退换货政策\r\n开口处较窄，便于往小罐中装填面粉、大米等干货，可防止洒落。', null, '水舀, 白色', null);
INSERT INTO `goods` VALUES ('32', 'PROPPMÄTT 乔迈特', '3', '../img/XQ3-2.jpg', '¥ 49.00', '111', '实木制成，实木是一种结实的天然材料，保护你的刀具。 还可以将砧板作为托盘直接呈上奶酪、熟肉或水果等食物。', '38x27 厘米', '砧板, 橡胶木', null);
INSERT INTO `goods` VALUES ('33', 'RISATORP 瑞沙托', '3', '../img/XQ3-3.png', '¥ 39.90', '100', null, '25x26x18 厘米', '篮, 白色', null);
INSERT INTO `goods` VALUES ('34', 'KUNGSFORS 康福斯', '3', '../img/XQ3-4.png', '¥ 39.90', '100', '这些网袋采用的棉花来自符合更可持续标准的种植园，可以在购物时取代塑料袋，而且它们还是“气候智能型”产品。把它们挂在挂钩上，用于存放水果和蔬菜，更长久保存食物。', null, '网袋，两件套, 自然色', null);
INSERT INTO `goods` VALUES ('35', 'VARIERA 瓦瑞拉', '3', '../img/XQ3-5.png', '¥ 15.90', '100', '这款实用的多功能储物盒便于你存放小物件，并能快速找到所需之物。你可以将储物盒放在柜子里、操作台面上，或家中任何地方，还可以随身携带。', '24x17 厘米', '盒子, 灰色', null);
INSERT INTO `goods` VALUES ('36', '../img/XQ3-4.pn', '3', '../img/XQ3-6.png', '¥ 9.90', '100', '这款马克杯由钢化玻璃制成，十分坚固，耐摔耐热。 由于玻璃非常耐热，可以用这款杯子盛装各类冷热饮品。', '25 厘升', '大杯, 透明玻璃', null);
INSERT INTO `goods` VALUES ('37', 'IDENTISK 伊坦迪', '3', '../img/XQ3-7.png', '¥ 129.00', '100', '由铸铁制成；传热均匀，保温时间长，能使食物均匀地变为焦黄色。 适用于各种类型的灶具，包括电磁炉。 两个把手便于将锅端起 来。', '32 厘米', '带盖中式炒菜锅, 深灰色, 铸铁', null);
INSERT INTO `goods` VALUES ('38', 'BURKEN 波肯', '3', '../img/XQ3-8.jpg', '¥ 6.90', '100', '每次倒出的量不大。', '20 厘升', '油 / 醋瓶', null);
INSERT INTO `goods` VALUES ('39', 'IRIS 艾瑞思', '3', '../img/XQ3-9.png', '¥ 19.90', '100', '中间的聚酯纤维毡层具有很好的隔热效果。', null, '锅垫, 灰色', null);
INSERT INTO `goods` VALUES ('40', 'IKEA 365+', '3', '../img/XQ3-10.png', '¥ 29.90', '100', '扣锁式盒盖可防止液体漏出，保护食物免遭冻坏，是携带食物和存放剩菜的理想之选。 该食品盒可放在烤箱中使用，也可用作烤箱盘/上菜用盘。', '1.0 公升', '附盖食品盒, 长方形 玻璃, 塑料 玻璃', null);
INSERT INTO `goods` VALUES ('41', 'IKEA 365+', '4', '../img/XQ4-1.png', '¥ 14.90', '100', 'IKEA 365+ 系列涵盖所有餐桌用具，你既可以选用单一的餐具，感受餐桌简约的魅力，也可以用色彩和配件点缀一二，令它更有活力。采用长石瓷制作，因此使用多年后仍然美观如初。', '13 厘米', '碗, 弧线型 白色', null);
INSERT INTO `goods` VALUES ('42', 'FÄRGRIK 法格里克', '4', '../img/XQ4-2.png', '¥ 12.90', '100', '无论你希望餐桌布置是精致的还是朴实的，其简洁、实用的设计都可以轻松跟其他造型和颜色的产品搭配。FÄRGRIK 法格里克 系列 适合所有用餐场合。', '16 厘米\r\n', '碗, 天蓝色', null);
INSERT INTO `goods` VALUES ('43', 'VARIERA 瓦瑞拉', '4', '../img/XQ4-3.png', '¥ 15.90', '100', '这款实用的多功能储物盒便于你存放小物件，并能快速找到所需之物。你可以将储物盒放在柜子里、操作台面上，或家中任何地方，还可以随身携带。', '24x17 厘米', '盒子, 灰色', null);
INSERT INTO `goods` VALUES ('44', 'IKEA 365+', '4', '../img/XQ4-4.png', '¥ 24.90', '100', '该食品盒可放在烤箱中使用，也可用作烤箱盘/上菜用盘。 这款食品盒采用玻璃材质，不吸收气味，不会被番茄酱等食物染色，易于清洁。', '400 ml', '附盖食品盒, 玻璃', null);
INSERT INTO `goods` VALUES ('45', 'VARDAGEN 瓦达恩', '4', '../img/XQ4-5.png', '¥ 9.90', '100', '透明罐子，无论放在哪里，都能让您轻松找到所需物品。 将干燥的食物贮存在带气味密封盖的食品罐内，可以延长保鲜时间，减少浪费。', '0.3 公升', '附盖罐, 透明玻璃', null);
INSERT INTO `goods` VALUES ('46', 'MEDLEM 麦德伦', '4', '../img/XQ4-6.jpg', '¥ 29.90', '199', '这款餐具既适合用于特殊场合，也适合为日常生活增添别致气息。造型简单，蓝色的图案经典清新，带来质朴之感。', '22 厘米', '餐盘, 白色/蓝色, 图案', null);
INSERT INTO `goods` VALUES ('47', 'EGENDOM 艾根多姆', '4', '../img/XQ4-7.jpg', '¥ 24.90', '100', 'EGENDOM 艾根多姆 碗采用珐琅制成，经久耐用，适合户外使用，易于清洁。非常适合孩子带着参加野餐或在家用餐使用。', '17 厘米', '碗, 淡灰色, 深蓝色', null);
INSERT INTO `goods` VALUES ('48', 'GARNERA 格尼拉', '4', '../img/XQ4-8.png', '¥ 99.00', '100', '使用上菜架盛放糕点、奶酪或水果，非常喜庆。', null, '上菜架，两层, 白色', null);
INSERT INTO `goods` VALUES ('49', 'FÄRGRIK 法格里克', '4', '../img/XQ4-9.png', '¥ 199.00', '100', '无论你希望餐桌布置是精致的还是朴实的，其简洁、实用的设计都可以轻松跟其他造型和颜色的产品搭配。FÄRGRIK 法格里克 系列 适合所有用餐场合。', null, '餐具18件, 浅绿', null);
INSERT INTO `goods` VALUES ('50', 'VARDAGEN 瓦达恩', '4', '../img/XQ4-10.png', '¥ 19.90', '100', '生活如同派对一样精彩，但大多数的日子却极为平淡。用这款设计简洁的经典餐具来盛放美食，可为平淡的日子增添乐趣。喜欢吗？有同一系列的不同尺寸可供选择。', '26 厘米', '碗, 透明玻璃', null);
INSERT INTO `goods` VALUES ('51', 'OFTAST 奥夫塔', '4', '../img/XQ4-11.png', '¥ 3.90', '100', '这款餐具的外观和质感与骨瓷相同，但实际是用钢化玻璃制成的。因此，我们可以降低价格，为你提供优雅光洁，同时又价格实惠的产品。', '15 厘米', '碗, 白色', null);
INSERT INTO `goods` VALUES ('52', 'TREBENT 特莱本', '4', '../img/XQ4-12.png', '¥ 7.90', '100', '带有不同装饰图案的竹筷可进行清洗并重复使用。', null, '4双筷子, 竹', null);
INSERT INTO `goods` VALUES ('53', 'OMLOPP 欧勒普', '7', '../img/XQ7-1.png', '¥ 99.00', '100', '这款灯可助你展示心爱的餐具系列，既能营造氛围，又可让橱柜里面的东西一目了然。方便自行安装，无需电工。', '6.8 厘米', 'LED射灯, 黑色', null);
INSERT INTO `goods` VALUES ('54', 'LINDSHULT 林舒', '7', '../img/XQ7-2.png', '¥ 199.00', '100', '柜子的完美搭档——它不仅能为柜子内部提供照明，还能营造出温馨舒适的房间氛围。可把它放在卧室衣柜的上方，或搭配客厅、厨房或门厅的储物件一起使用。', null, 'LED橱柜照明, 镀镍', null);
INSERT INTO `goods` VALUES ('55', 'ARÖD 阿洛德', '7', '../img/XQ7-3.png', '¥ 399.00', '100', '灯杆、灯头可调节，可轻松让光线投向需要位置。 可产生适合阅读的直射灯光。', null, '落地灯/ 阅读灯, 深灰色 煤黑色', null);
INSERT INTO `goods` VALUES ('56', 'TVÄRS 特瓦尔', '7', '../img/XQ7-4.png', '¥ 17.90', '111', '我们的设计师不惧挑战，力求打造价格实惠的灯具，而且在设计方面也没有丝毫马虎。他设计出了 TVÄRS 特瓦尔，这是一款富有趣意的情调照明灯具，极具未来感，仿佛是来自外太空的艺术品。非常棒！', null, '台灯, 白色', null);
INSERT INTO `goods` VALUES ('57', 'INGARED 因格利', '7', '../img/XQ7-5.jpg', '¥ 49.00', '100', '布艺灯罩可打造装饰性漫射灯光。', '30 厘米', '台灯, 米黄色', null);
INSERT INTO `goods` VALUES ('58', 'ÅRSTID 奥思迪', '7', '../img/XQ7-6.jpg', '¥ 149.00', '100', '这是我们最为珍视的灯具系列之一，款式经典，风格百搭。将这个系列的几款灯具组合使用，可营造出柔和舒适的光线，打造和谐的观感。', null, '台灯, 黄铜, 白色', null);
INSERT INTO `goods` VALUES ('59', 'FADO 法多', '7', '../img/XQ7-7.png', '¥ 99.00', '100', '在您的房间内打造柔和舒适的情调灯光。', null, '台灯, 灰色', null);
INSERT INTO `goods` VALUES ('60', 'LURVIG 乐维格', '6', '../img/XQ6-1.png', '¥ 149.00', '100', '猫猫狗狗也是家庭的一份子，占据着一定的居家空间。在 LURVIG 乐维格 系列中，你可以找到大多数宠物需要的用品，让它们能够和你一起享受美好生活。', '100x150 厘米', '宠物专用毯, 粉红色, 三角形', null);
INSERT INTO `goods` VALUES ('61', 'LURVIG 乐维格', '6', '../img/XQ6-2.png', '¥ 39.90', '100', '这个垫子可以把一条普通的桌子支腿变成一个猫抓垫，让你的猫在上面伸展身体，磨爪子。通过这个巧妙而实惠的方式，可以延长家中软垫家具的使用寿命。', '25x63 厘米', '抓板, 自然色', null);
INSERT INTO `goods` VALUES ('62', 'LURVIG 乐维格', '6', '../img/XQ6-3.png', '¥ 39.90', '100', '为你最好的朋友打造一个安全、舒适的地方，让它们可以蜷卧在里面休息。这款猫屋刚好可以放进 KALLAX 卡莱克 搁架单元里，而且外出旅行时可以轻松折叠和携带。', '33x38x33 厘米', '猫屋, 粉红色', null);
INSERT INTO `goods` VALUES ('63', 'LURVIG 乐维格', '6', '../img/XQ6-4.jpg', '¥ 349.00', '100', '无论你的宠物是猫还是狗，它们肯定都会爱上这个。特别是，座椅展开来就能变成一张宽敞的床，它们就可以在上面尽情地舒展身体。', '68x70 厘米', '宠物猫/狗床, 黑色', null);
INSERT INTO `goods` VALUES ('64', 'LURVIG 乐维格', '6', '../img/XQ6-5.jpg', '¥ 29.90', '100', '为你最好的朋友打造一个安全、舒适的地方，让它们可以蜷卧在里面休息。这款猫屋刚好可以放进 KALLAX 卡莱克 搁架单元里，而且外出旅行时可以轻松折叠和携带。', '33x38x33 厘米', '猫屋, 黑色', null);
INSERT INTO `goods` VALUES ('65', 'LURVIG 乐维格', '6', '../img/XQ6-6.png', '¥ 399.00', '199', '亲近的朋友要时刻陪伴在我们左右。将这款猫屋放在床边的地板上，挂在墙上，或者放进 KALLAX 卡莱克 搁架单元里。在这款舒适的猫屋里，你的爱猫可以安静地在你一旁休息，陪伴在你身边。', null, '带支腿猫屋, 白色', null);
INSERT INTO `goods` VALUES ('66', 'LURVIG 乐维格', '6', '../img/XQ6-7.png', '¥ 9.90', '100', '猫猫狗狗也是家庭的一份子，占据着一定的居家空间。在 LURVIG 乐维格 系列中，你可以找到大多数宠物需要的用品，让它们能够和你一起享受美好生活。', '33x33 厘米', '食盆垫, 白色', null);
INSERT INTO `goods` VALUES ('67', 'MÅLA 莫拉', '8', '../img/XQ8-1.jpg', '¥ 129.00', '100', '像专业艺术家一样发挥你的创意。选择画布，可以是黑板或白板，也可以放上 MÅLA 莫拉 画纸。书写板可折叠，方便带到自己最喜欢的地方。', null, '书写板, 软木, 白色', null);
INSERT INTO `goods` VALUES ('68', 'DUKTIG 杜克迪', '8', '../img/XQ8-2.png', '¥ 699.00', '111', '让小厨师的美梦成真。在这间摩登厨房里，孩子可以像电视中的大厨一样烹饪、烘焙和清洗餐具，并让家人品尝全新的美食。', '72x40x109 厘米', '玩具厨房, 桦木', null);
INSERT INTO `goods` VALUES ('69', 'PLUFSIG 普鲁希', '8', '../img/XQ8-3.jpg', '¥ 149.00', '100', '当地板上铺有体操垫时，孩子们很难按捺住自己的天性。孩子免不了会摔跟头、翻筋斗和玩乐，但是他们会很安全。到了休息的时间，只需要把垫子叠起来放在一旁。', '78x185 厘米', '可折叠健身垫, 粉红色', null);
INSERT INTO `goods` VALUES ('70', 'TROFAST 舒法特', '8', '../img/XQ8-4.png', '¥ 367.00', '100', '孩子需要玩的空间和玩具存放空间，TROFAST 舒法特 系列就是一款出色的玩具储物装置，它的框架采用坚固的木质结构，搭配轻便的塑料储物盒，让孩子轻松抽拉、搬动并放回原处。', '46x30x94 厘米\r\n', '储物组合带盒, 白色, 绿色 白色', null);
INSERT INTO `goods` VALUES ('71', 'GOSIG GOLDEN 古西格 格登', '8', '../img/XQ8-5.png', '¥ 99.00', '100', '无论你到哪里，贴心的毛绒玩具都可以伴你左右，并且在你空闲时陪你玩乐。休息时，你的小伙伴会拥抱着你，和你一起窝在沙发上尽情放松。', '70 厘米', '毛绒玩具, 黄色 狗, 金毛寻回犬', null);
INSERT INTO `goods` VALUES ('72', 'FABLER BJÖRN 费布勒 比约', '8', '../img/XQ8-6.jpg', '¥ 9.90', '100', '这款泰迪熊有一颗大大的心，很擅长拥抱、安慰和倾听，还能在你空闲时陪你玩乐嬉戏。你今天打算做什么？ 鲜明的对比和柔软的材质能刺激婴儿的感官发育。', '21 厘米', '毛绒玩具, 米黄色', null);
INSERT INTO `goods` VALUES ('73', 'TROFAST 舒法特', '8', '../img/XQ8-7.png', '¥ 10.00', '100', '可放入舒法特框架中。 盖上盖子后，可叠放。', '20x30x10 厘米', '储物箱, 黑色', null);
INSERT INTO `goods` VALUES ('74', 'BRUNBJÖRN 布朗伯恩', '8', '../img/XQ8-8.png', '¥ 39.90', '100', '这条温顺毛绒绒的泰迪熊喜欢世间一切美好的人和事，当然，它最喜欢的要数浆果了。不论是蓝莓还是红莓，它都喜欢。它是一个忠诚的朋友，在你需要安慰时，它能在身边紧紧抱着你。', null, '毛绒玩具, 熊', null);
INSERT INTO `goods` VALUES ('75', 'LILLÅNGEN 利兰根', '9', '../img/XQ9-1.png', '¥ 395.00', '100', '镜子背面有安全涂层，降低镜子破裂发生危险的可能。', '60x21x64 厘米', '双门镜柜, 白色', null);
INSERT INTO `goods` VALUES ('76', 'GODMORGON 古德莫', '9', '../img/XQ9-2.png', '¥ 1,795.00', '100', '享有10年品质保证，详情请见质保手册。 外部和内部都装有镜子。 镜门关到最后几厘米时可以自动关闭。 可调式钢化玻璃搁板； 特别耐热、结实、承载力大。', '60x21x64 厘米', '双门镜柜', null);
INSERT INTO `goods` VALUES ('77', 'HEMNES 汉尼斯', '9', '../img/XQ9-3.jpg', '¥ 995.00', '111', '可调式钢化玻璃搁板； 特别耐热、结实、承载力大。 镜子背面有安全涂层，降低镜子破裂发生危险的可能。', '63x16x98 厘米', '单门镜柜, 黑褐色', null);
INSERT INTO `goods` VALUES ('78', 'HEMNES 汉尼斯', '9', '../img/XQ9-4.jpg', '¥ 1,495.00', '100', '可调式钢化玻璃搁板； 特别耐热、结实、承载力大。 镜子背面有安全涂层，降低镜子破裂发生危险的可能。', '63x16x98 厘米', '双门镜柜, 黑褐色', null);
INSERT INTO `goods` VALUES ('79', 'HEMNES 汉尼斯', '9', '../img/XQ9-5.png', '¥ 1,795.00', '100', '可根据需调节搁板间距。 镜子背面有安全涂层，降低镜子破裂发生危险的可能。', '49x31x200 厘米', '高柜带镜门, 黑褐色', null);
INSERT INTO `goods` VALUES ('80', 'IKORNNES 伊库斯', '9', '../img/XQ9-6.jpg', '¥ 179.00', '11', '这款镜子既可以放在抽屉柜上，也可以悬挂在墙面上，使用效果一样。如果悬挂在墙面上，可以用它的台座来挂围巾或领带。圆润的外形和色调柔和的白蜡木贴面，给人以温馨舒适之感。', '27x40 厘米', '镜子, 白蜡木', null);
INSERT INTO `goods` VALUES ('81', 'KAITUM 凯顿', '9', '../img/XQ9-7.png', '¥ 149.00', '35', '额外照明，可为剃须或化妆等活动提供理想的照明环境。', '20 厘米', '镜子带照明, 电池操作', null);
INSERT INTO `goods` VALUES ('82', 'KARMSUND 卡宋德', '9', '../img/XQ9-8.png', '¥ 299.00', '45', '你可以通过装卸镜子顶端的装饰物，来变换镜子的风格。背后带有挂钩的可调节侧镜可令你在梳妆打扮时，从不同角度全方位照到自己。', '80x74 厘米', '镜子, 黑色', null);
INSERT INTO `goods` VALUES ('83', 'KARMSUND 卡宋德', '9', '../img/XQ9-9.jpg', '¥ 99.00', '99', '你可以通过装卸镜子顶端的装饰物，来变换镜子的风格。镜子下方的小托盘可用于存放小物件，如首饰和化妆品等。', '27x43 厘米', '镜子, 黑色', null);
INSERT INTO `goods` VALUES ('84', 'PATRULL 帕特鲁', '10', '../img/XQ10-1.jpg', '¥ 39.90', '99', '这款橡胶垫不仅是盆浴和淋浴的趣味配件，还降低了儿童滑倒和受伤的危险。 您可以在使用后将其挂起晾干，以保持垫子整洁清新。 垫子上的孔正适合悬挂。', '33x90 厘米', '浴缸防滑垫, 鳄鱼 绿色', null);
INSERT INTO `goods` VALUES ('85', 'PATRULL 帕特鲁', '10', '../img/XQ10-2.png', '¥ 39.90', '24', 'PATRULL 帕特鲁 防撞角可轻松减少孩子撞到桌边和橱柜锋利边缘的风险。', null, '防撞角, 白色', null);
INSERT INTO `goods` VALUES ('86', 'DOPPA 多帕', '10', '../img/XQ10-3.jpg', '¥ 39.90', '344', '吸盘设计可将浴缸或淋浴区的防滑垫安全固定在位。 可在使用后将其挂起晾干，以保持垫子整洁清新。垫子上的孔正适合悬挂。', '46 厘米', '淋浴防滑垫, 深灰色', null);
INSERT INTO `goods` VALUES ('87', 'PATRULL 帕特鲁', '10', '../img/XQ10-4.png', '¥ 49.00', '67', '多门闩设计可轻松防止孩子开启冰箱或冰柜的门。', null, '多功能门锁, 白色', null);
INSERT INTO `goods` VALUES ('88', 'FRAKTA 弗拉塔', '10', '../img/XQ10-5.png', '¥ 12.90', '54', '冰袋可冰冻食品约2小时。 带提手的便携式冷藏袋，适用于海边度假、野餐，或当天就把食物带回家！', '38x40 厘米', '冰袋, 蓝色', null);
INSERT INTO `goods` VALUES ('89', 'LUSTIGT 卢斯蒂格', '10', '../img/XQ10-6.jpg', '¥ 129.00', '34', '这款游戏有无数种玩法。你是玩家，可以在每轮中都创造新的规则。这是一项创意活动，可以在沙发上、桌子下进行，甚至无需触碰地面。', null, '地板游戏', null);
INSERT INTO `goods` VALUES ('90', 'LUSTIGT 卢斯蒂格', '10', '../img/XQ10-7.jpg', '¥ 59.00', '555', '由于图案上有许多小细节，每片拼图块的大小也不尽相同，因此这款拼图游戏对各个年龄段的玩家来说都是有趣的挑战。 拼图完成后，就可探索上面的图案。谁能第一个发现八爪鱼？', null, '拼图', null);
INSERT INTO `goods` VALUES ('91', 'ROCKÅN 罗克翁', '10', '../img/XQ10-8.jpg', '¥ 149.00', '56', '采用两侧软毛设计，配备可调腰带环、实用侧边袋和移动方便的保护套，非常舒适，适合你在家度过慵懒漫长的早晨。', null, '浴衣, 白色', null);
INSERT INTO `goods` VALUES ('92', 'GLITTRIG 格利其', '5', '../img/XQ5-1.png', '¥ 69.00', '435', 'GLITTRIG 格利其 系列旨在提升生活的方方面面：从舒适的夜晚到派对欢聚，均有涉及。该系列中的产品都易于搭配，所以你可以自己打造出美观而实用的组合。', null, '装饰盒，3件套, 乳白色, 金黄色', null);
INSERT INTO `goods` VALUES ('93', 'TILLSYN 提斯', '5', '../img/XQ5-2.jpg', '¥ 39.90', '44', '有趣且充满惊喜地装饰，将成为房间的亮点。', '16 厘米', '装饰沙漏, 透明玻璃', null);
INSERT INTO `goods` VALUES ('94', 'SJÄLSLIGT 梵思吉', '5', '../img/XQ5-3.jpg', '¥ 99.00', '100', '仙人掌由陶瓷制成，因此用这款绿色植物装点房间，你无需为它浇水。', null, '装饰品，3件套, 绿色', null);
INSERT INTO `goods` VALUES ('95', 'GESTALTA 吉特达', '5', '../img/XQ5-4.jpg', '¥ 39.90', '34', null, '33 厘米', '木人, 本色', null);
INSERT INTO `goods` VALUES ('96', 'MORGONTIDIG 穆隆提迪', '5', '../img/XQ5-5.png', '¥ 24.90', '32', '这款玻璃罩可用于展示你钟爱的装饰品。', '16 厘米', '玻璃罩, 透明玻璃', null);
INSERT INTO `goods` VALUES ('97', 'BEGÅVNING 比高宁', '5', '../img/XQ5-6.png', '¥ 49.00', '22', '带底座的玻璃顶可用于展示你钟爱的小物件。', '19 厘米', '带底座玻璃罩', null);
INSERT INTO `goods` VALUES ('98', 'BEGÅVNING 比高宁', '5', '../img/XQ5-7.jpg', '¥ 69.00', '12', '带底座的玻璃顶可用于展示你钟爱的小物件。', '26 厘米', '带底座玻璃罩', null);
INSERT INTO `goods` VALUES ('99', 'VINTERLIKT 温特里克', '5', '../img/XQ5-8.jpg', '¥ 59.00', '134', '例如，可以作为漂亮的桌面装饰。', null, '装饰物，马, 粉红色', null);

-- ----------------------------
-- Table structure for `orderform`
-- ----------------------------
DROP TABLE IF EXISTS `orderform`;
CREATE TABLE `orderform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderCode` varchar(255) DEFAULT NULL,
  `userID` varchar(255) DEFAULT NULL,
  `totalNum` varchar(255) DEFAULT NULL,
  `totalMoney` varchar(255) DEFAULT NULL,
  `orderDate` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderform
-- ----------------------------

-- ----------------------------
-- Table structure for `orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderFormID` varchar(255) DEFAULT NULL,
  `goodsID` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for `shoppingcart`
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userID` varchar(255) DEFAULT NULL,
  `goodsID` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `shoppingDate` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `creatDate` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'YY', '洋', '123456', '11', '18925553693', null, null);
