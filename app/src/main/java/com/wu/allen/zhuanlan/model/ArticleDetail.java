package com.wu.allen.zhuanlan.model;

import java.util.List;

/**
 * Created by allen on 2016/6/19.
 */
public class ArticleDetail {


    /**
     * isTitleImageFullScreen : false
     * rating : none
     * titleImage : https://pic1.zhimg.com/aa0da1510a8d64c96bf811072a35addc_r.jpg
     * links : {"comments":"/api/posts/20460225/comments"}
     * reviewers : []
     * topics : []
     * titleImageSize : {"width":719,"height":393}
     * href : /api/posts/20460225
     * author : {"profileUrl":"https://www.zhihu.com/people/fenggou","bio":"信息安全，鸡尾酒，电吉他，摄影。","hash":"1e373c5c6d9af3c8beaeb9aadc0890ac","name":"fenggou","isOrg":false,"slug":"fenggou","avatar":{"id":"939c20127","template":"https://pic4.zhimg.com/{id}_{size}.jpg"},"description":"写文字对于我来说挺痛苦的。"}
     * tipjarState : closed
     * content : 前几天写了个iPhone手机丢失后骗子是如何忽悠你交出AppleID账号密码的，一些名词解释和详细内容在这里 <a href="http://zhuanlan.zhihu.com/wooyun/20416511" class="internal">用iPhone的，丢过或者要丢的赶紧进来瞅瞅</a>，如果没看过的话要先点过去补补课，因为今天的内容更惊悚，更要加以防范！<p>这个攻击叫做“<b>GodLike攻击</b>”。<img src="https://pic1.zhimg.com/4c6759141c112e05371a9f314dbfe8c4_b.jpg" data-rawwidth="440" data-rawheight="500" class="origin_image zh-lightbox-thumb" width="440" data-original="https://pic1.zhimg.com/4c6759141c112e05371a9f314dbfe8c4_r.jpg"></p><p>上一篇内容提到的骗子手段还算文艺的，用各种各样“文案”忽悠你交出密码，但你以为不上道就没事儿了？流氓会武术，谁都拦不住。现在骗子们开始用上“黑科技”，通过漏洞直接盗取你的AppleID邮箱，自己给手机iCloud安全绑定取消掉！</p><p>首先，各种软磨硬泡钓鱼你不上钩后，会收到这样的邮件：</p><p><img src="https://pic2.zhimg.com/af24adad0c198bcf5a91e074e32378f1_b.jpg" data-rawwidth="541" data-rawheight="267" class="origin_image zh-lightbox-thumb" width="541" data-original="https://pic2.zhimg.com/af24adad0c198bcf5a91e074e32378f1_r.jpg">或者这样的</p><img src="https://pic3.zhimg.com/3fe12b318ae24159029d3df230b4243e_b.jpg" data-rawwidth="481" data-rawheight="272" class="origin_image zh-lightbox-thumb" width="481" data-original="https://pic3.zhimg.com/3fe12b318ae24159029d3df230b4243e_r.jpg"><p>哼哼，你以为骗子服软了？给点小钱就把手机还给你？图样啊……当你点开那张“照片”后，一段隐藏的恶意代码就在你的浏览器上欢快的开始干活了，“悄悄地进村，打枪的不要”。</p><img src="https://pic3.zhimg.com/a27c17050e874b32beaf8bcd18f09c62_b.jpg" data-rawwidth="500" data-rawheight="348" class="origin_image zh-lightbox-thumb" width="500" data-original="https://pic3.zhimg.com/a27c17050e874b32beaf8bcd18f09c62_r.jpg"><p>隐藏的恶意代码如下，算了，反正你们也看不懂，我就不放图了。总之，骗子所谓的照片或者店铺地址隐藏了一个名叫“<b>GodLike</b>”的html页面，这个页面中的恶意代码利用了国内某大型邮件服务商的漏洞，通过这个漏洞可以直接盗取你的邮箱控制权。</p><blockquote>主要是获取XX邮箱sid、skey等关键认证信息。</blockquote><p>还是放图吧，看看骗子的专业性。。。这张“图片”点开后是酱婶儿的，其实是个网页，藏着Godlike攻击代码</p><p><img src="https://pic3.zhimg.com/5732b514739470227318f8ae5d631d6e_b.jpg" data-rawwidth="800" data-rawheight="268" class="origin_image zh-lightbox-thumb" width="800" data-original="https://pic3.zhimg.com/5732b514739470227318f8ae5d631d6e_r.jpg">具体的GodLike攻击代码，窃取你邮箱的认证信息</p><img src="https://pic4.zhimg.com/4b768a2023f7ff8415d4c899325043e7_b.jpg" data-rawwidth="971" data-rawheight="441" class="origin_image zh-lightbox-thumb" width="971" data-original="https://pic4.zhimg.com/4b768a2023f7ff8415d4c899325043e7_r.jpg"><p>将窃取到的认证信息发送到骗子的远程服务器上记录与利用，你邮箱就这么丢的，现在造了不？感觉骗子专业吧，会用漏洞了。</p><p><img src="https://pic2.zhimg.com/8a8aa918903e217d1ad09a24a3dadb19_b.jpg" data-rawwidth="1276" data-rawheight="283" class="origin_image zh-lightbox-thumb" width="1276" data-original="https://pic2.zhimg.com/8a8aa918903e217d1ad09a24a3dadb19_r.jpg"><i>PS：上图来自于 <a href="https://www.zhihu.com/question/39019943" class="internal">js可以跨域得到cookie?qq邮箱被一封邮件黑了? </a> 中提供的线索，感谢。另外该邮箱漏洞目前已经修复（12月31日更新）</i></p><p>试想下，你用了XX厂的邮箱，然后还注册成了AppleID，那么当你点开这封邮件的时候，骗子通过漏洞窃取了你XX邮箱的控制权，然后上了你的邮箱翻些好玩的，顺便再给你AppleID的绑定给取消掉，好么，这次丢了邮箱又彻底赔了手机。。。</p><img src="https://pic2.zhimg.com/5253d241c9b9620b2083f7eebbdc26d5_b.jpg" data-rawwidth="494" data-rawheight="135" class="origin_image zh-lightbox-thumb" width="494" data-original="https://pic2.zhimg.com/5253d241c9b9620b2083f7eebbdc26d5_r.jpg"><p>乌云君目前接到了多起漏洞攻击举报，文件命名都是“<b>GodLike</b>”，所以将这种攻击行为命名为<b>GodLike攻击</b>，这种漏洞攻击力极强，不知骗子的音箱是否正回响着</p><blockquote><p><b>First Blood ！<br></b></p><p><b>Double Kill ！！<br></b></p><p><b>Triple Kill ！！！</b></p><p><b>M-m-m-m....Monster Kill ！！！！！</b></p><p><b>God Like ！！！！！</b></p><p>[骗子某] 已经接近神了。。。拜托谁杀了他把(350额外金钱)</p></blockquote><p><i>注：dota玩家都懂得。</i></p><p><i>再注：很多人遇到这种钓鱼邮件后，喜欢打开链接进行嘲讽（如安全技术人员），但切记在浏览器隐身模式下打开，否则你正登录着的XX邮箱也会被盗走（误伤啊，放过我）。。</i></p><p><i>最后注：该漏洞乌云君已经报告给XX邮箱官方，预计很快就会修复。目前防范手段就是不要在电脑或手机端直接打开邮件中的链接，在“隐身模式”中查看。</i></p><p><b>额外参考内容：</b></p><p><a href="https://link.zhihu.com/?target=http%3A//drops.wooyun.org/papers/11692" class=" wrap external" target="_blank" rel="nofollow noreferrer">黑产godlike攻击: 邮箱 XSS 窃取 appleID 的案例分析<i class="icon-external"></i></a><br></p><p><a href="https://www.zhihu.com/question/39019943" class="internal">js可以跨域得到cookie?qq邮箱被一封邮件黑了? - iPhone</a></p><br><p>--------------------------------------------</p><p>网站：<a href="https://link.zhihu.com/?target=http%3A//www.wooyun.org/" class=" wrap external" target="_blank" rel="nofollow noreferrer">乌云漏洞报告平台<i class="icon-external"></i></a></p><br><p>微博： <a href="https://link.zhihu.com/?target=http%3A//weibo.com/wooyun2" class=" wrap external" target="_blank" rel="nofollow noreferrer">乌云君<i class="icon-external"></i></a></p><p>微信： wooyun_org</p><p>知乎专栏： <a href="http://zhuanlan.zhihu.com/wooyun" class="internal">乌云君 - 知乎专栏</a></p><p>联系邮箱： help@wooyun.org</p>
     * state : published
     * sourceUrl :
     * commentPermission : anyone
     * canComment : true
     * snapshotUrl :
     * slug : 20460225
     * publishedTime : 2015-12-30T19:54:14+08:00
     * url : /p/20460225
     * title : 用iPhone的，丢过或者要丢的赶紧进来瞅瞅（二）
     * lastestLikers : [{"profileUrl":"https://www.zhihu.com/people/lu-xiao-feng-75-10","bio":"敏而好学","hash":"9c650de7d6970e725125bedde7b0ed4f","name":"陆小凤","isOrg":false,"slug":"lu-xiao-feng-75-10","avatar":{"id":"7495193c3","template":"https://pic4.zhimg.com/{id}_{size}.jpg"},"description":""},{"profileUrl":"https://www.zhihu.com/people/superman666","bio":"前端开发 / 摄影爱好者","hash":"90ca7906d37d0cab516dc81baba87bad","name":"超人不会飞","isOrg":false,"slug":"superman666","avatar":{"id":"c3368f968ea383ce15b0c5e6be612cbd","template":"https://pic2.zhimg.com/{id}_{size}.jpg"},"description":"博客：superman66.github.io"},{"profileUrl":"https://www.zhihu.com/people/inkdie","bio":"我不姓年，名字是我的生日。","hash":"6b6bb6b1aeb36a85cbd88455d7038662","name":"A小年","isOrg":false,"slug":"inkdie","avatar":{"id":"e31be3f17","template":"https://pic4.zhimg.com/{id}_{size}.jpg"},"description":"唉，你视奸我！"},{"profileUrl":"https://www.zhihu.com/people/e-na-come","bio":"","hash":"c0d389562ed3720275c3ee0b1a51e4f0","name":"哦那come","isOrg":false,"slug":"e-na-come","avatar":{"id":"da8e974dc","template":"https://pic1.zhimg.com/{id}_{size}.jpg"},"description":""},{"profileUrl":"https://www.zhihu.com/people/auras-power","bio":"无尽循环甲虫","hash":"85ab1f72157e16c63428f2e6cf2976cb","name":"Auras Power","isOrg":false,"slug":"auras-power","avatar":{"id":"095297c22371d02563801a1a3f380042","template":"https://pic3.zhimg.com/{id}_{size}.jpg"},"description":""}]
     * summary : <img src="https://pic3.zhimg.com/3fe12b318ae24159029d3df230b4243e_200x112.jpg" data-rawwidth="481" data-rawheight="272" class="origin_image inline-img zh-lightbox-thumb" data-original="https://pic3.zhimg.com/3fe12b318ae24159029d3df230b4243e_r.jpg">前几天写了个iPhone手机丢失后骗子是如何忽悠你交出AppleID账号密码的，一些名词解释和详细内容在这里 <a href="http://zhuanlan.zhihu.com/wooyun/20416511" class="internal">用iPhone的，丢过或者要丢的赶紧进来瞅瞅</a>，如果没看过的话要先点过去补补课，因为今天的内容更惊悚，更要加以防范！这个攻击叫做“<b>GodLike攻击</b>”。上一…
     * column : {"slug":"wooyun","name":"乌云君"}
     * meta : {"previous":{"isTitleImageFullScreen":false,"rating":"none","titleImage":"https://pic3.zhimg.com/a30ea3ed0b85fb52baaae17f24691a12_r.jpg","links":{"comments":"/api/posts/20416511/comments"},"topics":[],"href":"/api/posts/20416511","author":{"profileUrl":"https://www.zhihu.com/people/fenggou","bio":"信息安全，鸡尾酒，电吉他，摄影。","hash":"1e373c5c6d9af3c8beaeb9aadc0890ac","name":"fenggou","isOrg":false,"slug":"fenggou","avatar":{"id":"939c20127","template":"https://pic4.zhimg.com/{id}_{size}.jpg"},"description":"写文字对于我来说挺痛苦的。"},"content":"如果你是iPhone用户，<b>那今天的内容对你来说挺重要<\/b>。这个事儿也许你经历过，也许你的朋友遇到过，但你没遇到过不知所以然，不过无需担心，乌云君马上给你娓娓道来，再重复一次：<b>今天这事儿对iPhone用户很重要！<\/b><p>忘记从iOS哪个版本开始，苹果对iPhone上登录的AppleID（iCloud账号，就是你同步你通讯录、照片需要的那个账号）进行了严格的绑定措施。在没有iCloud密码的情况下，其他人没法把你账号注销换成自己的。换句话说，你的这部iPhone登录iCloud账号后，除非你主动解除绑定，否则控制权将一直属于你。<\/p><img src=\"https://pic4.zhimg.com/8d337fd28094fe5b66f71210712de1d7_b.jpg\" data-rawwidth=\"532\" data-rawheight=\"492\" class=\"origin_image zh-lightbox-thumb\" width=\"532\" data-original=\"https://pic4.zhimg.com/8d337fd28094fe5b66f71210712de1d7_r.jpg\"><p>挺好的不是么，买了个属于自己的东西，比那啥只能使用70年强多了。但是，但是！有个行业不爽了，那就是传说中的 \u201c\u2018偷\u2019机倒手\u201d 族，专注于偷手机、然后销赃的利益链。因苹果的这个绑定机制，偷来的手机不好卖了，买家绑定不了自己账号还面临随时被原主人锁机的风险谁干那？但做这个买卖的没有傻子，他们很快就想到了完美的应对方案：<b>骗<\/b>（别笑，这个方案在中国真的可以说完美）！<\/p><p>于是在丢失iPhone后，我们开始收到这样的短信／邮件：<\/p><p><img src=\"https://pic1.zhimg.com/e379308e9793d985a53314856ac332c0_b.jpg\" data-rawwidth=\"489\" data-rawheight=\"565\" class=\"origin_image zh-lightbox-thumb\" width=\"489\" data-original=\"https://pic1.zhimg.com/e379308e9793d985a53314856ac332c0_r.jpg\">手机丢了本来就心慌，里面存的那些照片、视频让别人看着可咋整啊\u2026\u2026结果收到这种信息后，一下又充满了希望。原来可以拒绝其他人激活看到俺的信息，还能定位？赶紧看看偷手机的小兔崽子在哪！结果头一晕，手一快，手机彻底找不回来了不说，还将自己的iCloud账号拱手送给了骗子。<\/p><p>等等，刚刚剧情发展有点快，没看懂，这中间到底都发生了啥？点开明明就是iCloud登录页面么，那么酷炫屌炸天的Apple style我不会认错的。那现在乌云君镜头慢回放，仔细看下点开的网站：<\/p><img src=\"https://pic2.zhimg.com/bd95f2891f3cf744aae15e386c39ea41_b.jpg\" data-rawwidth=\"1059\" data-rawheight=\"697\" class=\"origin_image zh-lightbox-thumb\" width=\"1059\" data-original=\"https://pic2.zhimg.com/bd95f2891f3cf744aae15e386c39ea41_r.jpg\"><p>看看Apple官方的样子<\/p><p><img src=\"https://pic4.zhimg.com/82c6f52adcfe11fdf2b7e165d1c4b84f_b.jpg\" data-rawwidth=\"1062\" data-rawheight=\"692\" class=\"origin_image zh-lightbox-thumb\" width=\"1062\" data-original=\"https://pic4.zhimg.com/82c6f52adcfe11fdf2b7e165d1c4b84f_r.jpg\">https还算是一个识别依据吧，但也不是100%的，比如乌云社区的这个案例，骗子竟然也上了合法的https证书（<a href=\"https://link.zhihu.com/?target=http%3A//zone.wooyun.org/content/24005\" class=\" wrap external\" target=\"_blank\" rel=\"nofollow noreferrer\">发现一个仿真度极高的Paypal钓鱼网站还支持SSL<i class=\"icon-external\"><\/i><\/a>），最靠谱的还是做到百分之百识别官方域名 <b><a href=\"https://link.zhihu.com/?target=http%3A//icloud.com\" class=\" external\" target=\"_blank\" rel=\"nofollow noreferrer\"><span class=\"invisible\">http://<\/span><span class=\"visible\">icloud.com<\/span><span class=\"invisible\"><\/span><i class=\"icon-external\"><\/i><\/a> <\/b>吧，要啥奇技淫巧啊这么简单的事儿 ：（<\/p><p><b>--------- 牛逼闪闪的分割线 ----------<\/b><\/p><p>其实上面的内容大家多少都知道点哈\u2026就这么结束显然不够逼格，所以下面要放出重磅炸弹，白帽子对这种钓鱼平台的后台进行数据揭秘，看看到底有多少人中招，骗子怎么收密码的，以下内容来自乌云白帽子报告：<a href=\"https://link.zhihu.com/?target=http%3A//www.wooyun.org/bugs/wooyun-2015-0161152\" class=\" wrap external\" target=\"_blank\" rel=\"nofollow noreferrer\">利用漏洞揭秘iCloud钓鱼网站（涉及20余个钓鱼站点，最近1个月1.3万Apple受害者）<i class=\"icon-external\"><\/i><\/a><\/p><p>首先白帽子对自己收到的这个iCloud骗子网站进行了深入的分析（骗错人了hiahia），不出意料发现了一个漏洞，这个漏洞不一般，感觉更像是钓鱼行业中\u201c黑吃黑\u201d现象故意留的后门（你买我的钓鱼程序，但后期我能悄悄的拿走你骗来的成果，对用户账号造成二次泄露影响），这个牛逼哄哄的漏洞是酱婶儿的<\/p><p><img src=\"https://pic2.zhimg.com/d83072ebfc00fe43fea06523919a9151_b.jpg\" data-rawwidth=\"907\" data-rawheight=\"466\" class=\"origin_image zh-lightbox-thumb\" width=\"907\" data-original=\"https://pic2.zhimg.com/d83072ebfc00fe43fea06523919a9151_r.jpg\">白帽子在这个钓鱼站上找到这个链接，打开后直接就是发件箱配置，里面一个163邮箱，密码星号看不到。不急，右键查看源代码，找到了星号下的明文邮箱密码，登录之，duang！<b>原来受骗者填写的iCloud账号密码是通过这个邮箱发给后面的骗子。<\/b><\/p><p><img src=\"https://pic1.zhimg.com/c2ef8a384348117e424b859e5451d424_b.jpg\" data-rawwidth=\"823\" data-rawheight=\"848\" class=\"origin_image zh-lightbox-thumb\" width=\"823\" data-original=\"https://pic1.zhimg.com/c2ef8a384348117e424b859e5451d424_r.jpg\">随便点开一封邮件瞅瞅，老板请核实资料？<\/p><p><img src=\"https://pic2.zhimg.com/c340523c45a5b0d9ffe956cd620e331d_b.jpg\" data-rawwidth=\"597\" data-rawheight=\"415\" class=\"origin_image zh-lightbox-thumb\" width=\"597\" data-original=\"https://pic2.zhimg.com/c340523c45a5b0d9ffe956cd620e331d_r.jpg\">有了这个信息，就能解除iCloud绑定了，白帽子在这几分钟的时间内，发现这个邮箱仍然在对外发新的受骗者信息，可见其活跃。通过这个邮箱不完全统计，<b>该骗子在一个月内竟成功骗到了一万三千多个iCloud账号和密码<\/b>！<\/p><img src=\"https://pic1.zhimg.com/1ae4055e2ace9b576ee53f0df09a1e20_b.jpg\" data-rawwidth=\"681\" data-rawheight=\"394\" class=\"origin_image zh-lightbox-thumb\" width=\"681\" data-original=\"https://pic1.zhimg.com/1ae4055e2ace9b576ee53f0df09a1e20_r.jpg\"><p>飞蛾扑火，前赴后继。明显感觉到这骗子已经累惨，平均每天要去验证433个iCloud账号，然后解绑手机点钱，这活儿还真有点吸引力呢。关于iPhone手机的倒卖行业，乌云君也做了些了解，丢了想找回来几乎不可能，在各种钓鱼手段狂轰滥炸一个月后没中招的话，骗子会将你的手机买配件，大概2k左右的价格也很可观。所以iPhone丢失后，不要抱有太多的幻想能够找回手机，期望越大，你越容易落入陷阱。<\/p><img src=\"https://pic4.zhimg.com/6db29f0400d59c44c1866cf7fe0505a7_b.jpg\" data-rawwidth=\"440\" data-rawheight=\"253\" class=\"origin_image zh-lightbox-thumb\" width=\"440\" data-original=\"https://pic4.zhimg.com/6db29f0400d59c44c1866cf7fe0505a7_r.jpg\"><p>所以乌云君的建议是平时的锁屏密码设置复杂些，毕竟都指纹解锁了，麻烦不到哪去，同步备份也勤快些省的丢失数据；其次丢失手机第一时间登录iCloud锁定手机，并在接下来的一段时间内警惕任何收到的短信、邮件（有的骗子直接跳出伪装跟你聊QQ，中间威逼利诱，比如你给500机器就还给你之类的，大家好自为之）。<\/p><p>哦对了，这事儿有破案的先例：<a href=\"https://link.zhihu.com/?target=http%3A//news.wooyun.org/436b7866714844686d544f54617472525678763968513d3d\" class=\" wrap external\" target=\"_blank\" rel=\"nofollow noreferrer\">刚丢 iPhone 就收到 Apple ID 异常邮件？小心被钓鱼（已有近 3000 人中招）<i class=\"icon-external\"><\/i><\/a><\/p><p>最后微博上收集了一些热心网友讨论，分享一下，今天就酱：<\/p><blockquote><p>***Angeles：一看短信就知道假的，擦 人家官方几时写iPhone 为 iphone 过啊，大小写很注重的好吧 （细节党，赞）<br><\/p><p>三不知大师：故意输错密码账号试试能不能通过 （这还真是个小技巧，但不准）<br><\/p><p>余博伦是讨厌鬼：这前端仿得不错哈 （是的，好的钓鱼前端能迷倒千千万）<br><\/p><p>Leona***：小时候玩剑侠情缘网络版，被骗子的免费点卡充值引诱，在山寨官网上填写账号从而被盗号以后，对于任何需要填写密码的网页我都是检查了又检查。已坚持了十二年。 （一朝被蛇咬，十二年怕井绳，不过谨慎是个好事儿少年）<br><\/p><p>亦半亦*：手机丢后也收到过 如果不是苹果客服提醒骗子会想方设法的套取我的用户名和密码就信了 还好自己也上假冒网站上去过F12看了下就一张图片和一个表单提交控件。。 （技术流，但看域名更简单一些）<br><\/p><p>iTo***: 手机丢啦，苹果也不会主动发短信给你的！所以这样的短信只能是骗子想获取你的id。稍后的每日一技中会提到~不过大家还是要注意下啦！<\/p><\/blockquote><p>--------------------------------------------<\/p><p>网站：<a href=\"https://link.zhihu.com/?target=http%3A//www.wooyun.org/\" class=\" wrap external\" target=\"_blank\" rel=\"nofollow noreferrer\">乌云漏洞报告平台<i class=\"icon-external\"><\/i><\/a><\/p><br><p>微博： <a href=\"https://link.zhihu.com/?target=http%3A//weibo.com/wooyun2\" class=\" wrap external\" target=\"_blank\" rel=\"nofollow noreferrer\">乌云君<i class=\"icon-external\"><\/i><\/a><\/p><p>微信： wooyun_org<\/p><p>知乎专栏： <a href=\"http://zhuanlan.zhihu.com/wooyun\" class=\"internal\">乌云君 - 知乎专栏<\/a><\/p><p>联系邮箱： help@wooyun.org<\/p>","state":"published","sourceUrl":"","commentPermission":"anyone","canComment":true,"snapshotUrl":"","slug":20416511,"publishedTime":"2015-12-14T19:13:38+08:00","url":"/p/20416511","title":"用iPhone的，丢过或者要丢的赶紧进来瞅瞅","summary":"如果你是iPhone用户，<b>那今天的内容对你来说挺重要<\/b>。这个事儿也许你经历过，也许你的朋友遇到过，但你没遇到过不知所以然，不过无需担心，乌云君马上给你娓娓道来，再重复一次：<b>今天这事儿对iPhone用户很重要！<\/b>忘记从iOS哪个版本开始，苹果对iPhone上登录的A\u2026","column":{"slug":"wooyun","name":"乌云君"},"meta":{"previous":null,"next":null},"reviewingCommentsCount":0,"commentsCount":0,"likesCount":0},"next":{"isTitleImageFullScreen":false,"rating":"none","titleImage":"https://pic4.zhimg.com/04129f190219918c6f2c597daed1a6ab_r.jpg","links":{"comments":"/api/posts/20581814/comments"},"topics":[],"href":"/api/posts/20581814","author":{"profileUrl":"https://www.zhihu.com/people/fenggou","bio":"信息安全，鸡尾酒，电吉他，摄影。","hash":"1e373c5c6d9af3c8beaeb9aadc0890ac","name":"fenggou","isOrg":false,"slug":"fenggou","avatar":{"id":"939c20127","template":"https://pic4.zhimg.com/{id}_{size}.jpg"},"description":"写文字对于我来说挺痛苦的。"},"content":"<p>一提到车牌，就忍不住放这个梗。。。<\/p><img src=\"https://pic1.zhimg.com/52244d8c855eed0215609cc9b45c15fc_b.jpg\" data-rawwidth=\"800\" data-rawheight=\"600\" class=\"origin_image zh-lightbox-thumb\" width=\"800\" data-original=\"https://pic1.zhimg.com/52244d8c855eed0215609cc9b45c15fc_r.jpg\"><p>去年乌云君曝光了一些车主信息被非法交易买卖的事情，这些数据会从汽车销售商、总部客户系统中被泄露，然后用来做一些广告推销或违章诈骗等危害用户权益的行为，比如这样（apk文件为android手机木马程序）<\/p><img src=\"https://pic4.zhimg.com/d62bbc91305cb9512cfcacd6fb9c3aab_b.jpg\" data-rawwidth=\"671\" data-rawheight=\"397\" class=\"origin_image zh-lightbox-thumb\" width=\"671\" data-original=\"https://pic4.zhimg.com/d62bbc91305cb9512cfcacd6fb9c3aab_r.jpg\"><p>或这样<\/p><img src=\"https://pic4.zhimg.com/7668deaf17d3036f5dad10bd4ab46d9f_b.jpg\" data-rawwidth=\"373\" data-rawheight=\"298\" class=\"content_image\" width=\"373\"><p>车辆信息除了汽车经销商，车辆管理等机构，更大的一个信息聚集地就是保险公司，因为车险是每个车主都必须要购买的，并且需要超详细的个人信息记录。那保险公司是否也会给用户造成不必要的泄密困扰呢？<\/p><p>有乌云白帽之前发现了阳光保险公司一个惊呆的漏洞 <a href=\"https://link.zhihu.com/?target=http%3A//www.wooyun.org/bugs/wooyun-2015-0159339\" class=\" wrap external\" target=\"_blank\" rel=\"nofollow noreferrer\">阳光保险某安全漏洞可查询海量车主信息（车架号、发动机号、姓名、身份证号等）<i class=\"icon-external\"><\/i><\/a> ，只要你知道对方的车牌号码，就能够查询车辆以及车主信息，甚至还能查到其最近的违章记录！<\/p><p>首先进入该保险公司车险报价查询页面，输入你想查询的车牌号码与地区，然后个人信息随便填（对就是随便填写，不用与真实车主信息吻合），选个牛逼的号码<\/p><img src=\"https://pic3.zhimg.com/b1aeaa84fff50332eabff63558a6267a_b.jpg\" data-rawwidth=\"722\" data-rawheight=\"605\" class=\"origin_image zh-lightbox-thumb\" width=\"722\" data-original=\"https://pic3.zhimg.com/b1aeaa84fff50332eabff63558a6267a_r.jpg\"><p>然后点击下一步，没挑战，车架号、发动机号、车主姓名、身份证号码都出来了<\/p><img src=\"https://pic2.zhimg.com/639913239c99aa0520ad7dce2e1994c1_b.jpg\" data-rawwidth=\"412\" data-rawheight=\"373\" class=\"content_image\" width=\"412\"><p>不同地区查询的信息结果不同，还可以更详细一些<\/p><img src=\"https://pic4.zhimg.com/e91251aa4cc574d042484685a8fb5193_b.png\" data-rawwidth=\"357\" data-rawheight=\"323\" class=\"content_image\" width=\"357\"><p>车主信息指哪打哪，利用发动机号等信息还可以查询车主近期的违章记录，这用来诈骗不妥妥的？比如另个北京土豪号码近期的违章记录。。。<\/p><img src=\"https://pic2.zhimg.com/1e5d460e43007882fdb64a72acdea2e5_b.png\" data-rawwidth=\"419\" data-rawheight=\"534\" class=\"content_image\" width=\"419\"><p>车牌信息的定向查询，加上如今各种\u201c社工库\u201d的配合，能给车主带来不小的麻烦。随便上个路被黑客盯上了，一系列的麻烦可能会接踵而来。同样，各类的保险也是更多行业间信息泄露的另类途径。<\/p><br><p>--------------------------------------------<\/p><p>网站：<a href=\"https://link.zhihu.com/?target=http%3A//www.wooyun.org/\" class=\"internal\">乌云漏洞报告平台<\/a><\/p><br><p>微博： <a href=\"https://link.zhihu.com/?target=http%3A//weibo.com/wooyun2\" class=\"internal\">乌云君<\/a><\/p><p>微信： wooyun_org<\/p><p>知乎专栏： <a href=\"http://zhuanlan.zhihu.com/wooyun\" class=\"internal\">乌云君 - 知乎专栏<\/a><\/p><p>联系邮箱： help@wooyun.org<\/p>","state":"published","sourceUrl":"","commentPermission":"anyone","canComment":true,"snapshotUrl":"","slug":20581814,"publishedTime":"2016-02-18T15:18:42+08:00","url":"/p/20581814","title":"汽车号牌已变成新的信息泄露入口？！","summary":"一提到车牌，就忍不住放这个梗。。。去年乌云君曝光了一些车主信息被非法交易买卖的事情，这些数据会从汽车销售商、总部客户系统中被泄露，然后用来做一些广告推销或违章诈骗等危害用户权益的行为，比如这样（apk文件为android手机木马程序）或这样车辆信息\u2026","column":{"slug":"wooyun","name":"乌云君"},"meta":{"previous":null,"next":null},"reviewingCommentsCount":0,"commentsCount":0,"likesCount":0}}
     * reviewingCommentsCount : 0
     * commentsCount : 26
     * likesCount : 245
     */

    private String titleImage;
    /**
     * comments : /api/posts/20460225/comments
     */

    private LinksBean links;
    private String content;
    private int slug;
    private String publishedTime;
    private String title;
    private String summary;
    private int commentsCount;
    private int likesCount;
    private List<?> reviewers;
    private List<?> topics;

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public LinksBean getLinks() {
        return links;
    }

    public void setLinks(LinksBean links) {
        this.links = links;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSlug() {
        return slug;
    }

    public void setSlug(int slug) {
        this.slug = slug;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public List<?> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<?> reviewers) {
        this.reviewers = reviewers;
    }

    public List<?> getTopics() {
        return topics;
    }

    public void setTopics(List<?> topics) {
        this.topics = topics;
    }

    public static class LinksBean {
        private String comments;

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }
    }
}
