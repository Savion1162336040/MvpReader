package com.savion.mvpreader.model.bean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2018-01-02.
 */

public class NewsMessageSource {

    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"uniquekey":"0ee34f10926180b6f6e67175e57c10d8","title":"伦敦举行2018新年街头游行 美女街头载歌载舞","date":"2018-01-02 10:19","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102101920933.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102101920_0b43bdad201e8ba10e199ec7256cdb39_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180102/20180102101920_0b43bdad201e8ba10e199ec7256cdb39_10_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180102/20180102101920_0b43bdad201e8ba10e199ec7256cdb39_7_mwpm_03200403.jpg"},{"uniquekey":"5666908c809ec2b4a8a177678c87afed","title":"澳大利亚数百万只袋鼠神秘死亡 或感染疾病所致","date":"2018-01-02 10:19","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102101921738.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180102/20180102101921_f9156641fc820d2b8187e4a6f52f04e0_1_mwpm_03200403.jpg"},{"uniquekey":"bf7173ff9938355611704c2c5193ed4e","title":"新年伊始 法国巴黎大区公交建设发布新\u201c路线图\u201d","date":"2018-01-02 10:19","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102101921022.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102101921_d20c239f054ee53a1b0e3ce8fcc37d1d_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180102/20180102101921_d20c239f054ee53a1b0e3ce8fcc37d1d_2_mwpm_03200403.jpg"},{"uniquekey":"403c87c50687233c6b1fa1b151e6e65c","title":"鲁哈尼呼吁冷静未奏效 伊朗周一继续爆发示威游行","date":"2018-01-02 10:19","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102101920422.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180102/20180102101920_a6b2f9fd5de7caea70aa073c5c1e3ac3_1_mwpm_03200403.jpg"},{"uniquekey":"242b8694f113b706382f76ddf92aa4d9","title":"韩国总统文在寅赴显忠院参拜为新年祈愿","date":"2018-01-02 09:58","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102095844158.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102095844_5b64d1c3e375d8e374c7c614010318ef_1_mwpm_03200403.jpg"},{"uniquekey":"77432f09064b462989bdcff483ce0062","title":"2018上海落户政策，满足这些就可以轻松落户啦！","date":"2018-01-02 09:50","category":"头条","author_name":"上海本地宝","url":"http://mini.eastday.com/mobile/180102095008444.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102095008_66174ef95ac0c75bdec636de8c5423c7_1_mwpm_03200403.jpg"},{"uniquekey":"a3843f2a9cc2e0efe022034126ef7bef","title":"伊朗爆发抗议游行，不能一味地归咎于外部因素","date":"2018-01-02 09:48","category":"头条","author_name":"观察者网","url":"http://mini.eastday.com/mobile/180102094851757.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180102/20180102094851_264caed8878da6fedd41ab8d1f5b9355_1_mwpm_03200403.jpg"},{"uniquekey":"3a02ea6998a0155e4f1c563b38bdffe1","title":"马华裔男子因外形被女友抛弃 整成型男后感叹\u201c世界太现实\u201d","date":"2018-01-02 09:48","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102094815126.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180102/20180102094815_88bc19738d2e1524b2d6c8609f706806_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20180102/20180102094815_88bc19738d2e1524b2d6c8609f706806_1_mwpm_03200403.jpg"},{"uniquekey":"3098ad5efeaaa1df5cc5523c56c514f9","title":"文汇战略 | 特朗普鲁哈尼隔空互怼，西方推波助澜，伊朗持续示威会演变成\u201c颜色革命\u201d吗？","date":"2018-01-02 09:46","category":"头条","author_name":"文汇网","url":"http://mini.eastday.com/mobile/180102094633046.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180102/20180102094633_7d4adaa88ee9480bc6ae99e553a4ecfd_1_mwpm_03200403.jpg"},{"uniquekey":"09978c0ed06ac06b51dbc1970e7cb77d","title":"瑞士新《收养法》生效 同性恋获许收养继子","date":"2018-01-02 09:37","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102093759535.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180102/20180102093759_b5783b0330ab6adf1e9205ec07730b40_1_mwpm_03200403.jpg"},{"uniquekey":"c3ec57aeda58b519c3deab6a7192681b","title":"无人机之旅|2017爱上湖北的航拍在这儿","date":"2018-01-02 09:29","category":"头条","author_name":"新华网","url":"http://mini.eastday.com/mobile/180102092957459.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102092957_f1cc1f8bc7107fdf0e61cf2c3068dfd6_8_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180102/20180102092957_450b0a76919b96767ba28008dbe097f8_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180102/20180102092957_9433f5f4a95cfb531f7e881ab012111b_10_mwpm_03200403.jpg"},{"uniquekey":"d6d40cdd501084c7f010fadd8a26ec21","title":"好莱坞数百位大咖女性发声 关注劳工职场骚扰","date":"2018-01-02 09:27","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102092742696.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180102/20180102092742_10a100d78ec9b80fb1785dfd009adf45_1_mwpm_03200403.jpg"},{"uniquekey":"55f83a76f04d57070a74c2ff374891cd","title":"法国财长：法国有意建立从欧洲经莫斯科到北京的\u201c商路\u201d","date":"2018-01-02 09:17","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102091727777.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102091727_05df455fc4656a61c72757670307b434_1_mwpm_03200403.jpg"},{"uniquekey":"4022be0e1b4ed90ee8aa0adeb1df9731","title":"祖母留下的破毛毯卖到975万！他瞬间成富翁，亲戚却不干了","date":"2018-01-02 09:16","category":"头条","author_name":"看什么鬼","url":"http://mini.eastday.com/mobile/180102091602401.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102_4e15682d81a333e35f5e268442c7c315_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180102/20180102_968e8dc4683b4f72c93f8fd3e041a08a_cover_mwpm_03200403.jpg"},{"uniquekey":"33a5a6d9bb3a7f5968a55983dc05ccc6","title":"朝鲜释放善意，就看美国如何接招，如果一意孤行，将失去道义！","date":"2018-01-02 09:04","category":"头条","author_name":"第一军情","url":"http://mini.eastday.com/mobile/180102090442044.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102_ab3ab2f2f5f1ffd3912efdc9bf49eeb7_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180102/20180102_de4a8ab8928c9878abbf9d5f816892d2_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180102/20180102_770b40b40a40fa119974c83c988316ce_cover_mwpm_03200403.jpg"},{"uniquekey":"7e48395cb5aeab9128cf373e72646579","title":"菲利普亲王又失言 笑称\u201c大胡子男为恐怖分子\u201d","date":"2018-01-02 08:56","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102085650210.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180102/20180102085650_178d083b484f1ca24d7630be8fa7b00c_1_mwpm_03200403.jpg"},{"uniquekey":"e86ccf3fae8f6769a0b45082a0934cd1","title":"上海垃圾偷倒太湖的背后，是特大城市的\u201c垃圾围城\u201d","date":"2018-01-02 08:55","category":"头条","author_name":"凤凰社会","url":"http://mini.eastday.com/mobile/180102085550191.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102085550_2f049b230745990f71e04e937d25da29_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180102/20180102085550_2f049b230745990f71e04e937d25da29_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20180102/20180102085550_2f049b230745990f71e04e937d25da29_2_mwpm_03200403.jpg"},{"uniquekey":"ae09208a8402686f8f01ed227f5811fd","title":"早安海峡：蔡英文元旦升旗多\u201c独派\u201d抗议","date":"2018-01-02 08:35","category":"头条","author_name":"中国台湾网","url":"http://mini.eastday.com/mobile/180102083555911.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102083555_0c26c6c8f1502d7213afacbfd1e15c14_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180102/20180102083555_0c26c6c8f1502d7213afacbfd1e15c14_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180102/20180102083555_0c26c6c8f1502d7213afacbfd1e15c14_1_mwpm_03200403.jpg"},{"uniquekey":"7d5c73e0869c0135c8096d516a0a7315","title":"乔治娅-尼克斯1月1日至7日 本周星座运势","date":"2018-01-02 08:31","category":"头条","author_name":"Lonia占星","url":"http://mini.eastday.com/mobile/180102083106794.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102083106_ed3808c02cc8f7763084b9d5e7d8cb51_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180102/20180102083106_ed3808c02cc8f7763084b9d5e7d8cb51_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20180102/20180102083106_ed3808c02cc8f7763084b9d5e7d8cb51_5_mwpm_03200403.jpg"},{"uniquekey":"bd6ecad059bbb28dd7e056570aa10bf6","title":"和蛇相依的农村少女，如今活成可这样，让人心疼不已","date":"2018-01-02 08:29","category":"头条","author_name":"娱乐部落阁","url":"http://mini.eastday.com/mobile/180102082904620.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102_2d6dc975e4f6ae6d1f55412fb904c4d2_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180102/20180102_ec4f26f8417dfc7ea6091f9b1c9f9be5_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20180102/20180102_e61095ad6adff7f869278d0ec6a37774_cover_mwpm_03200403.jpg"},{"uniquekey":"7a933d9aa780732bba6acc78875c09b7","title":"半岛发生巨变！朝鲜刚刚以退为进，给特朗普最沉重一击","date":"2018-01-02 08:28","category":"头条","author_name":"大国军情","url":"http://mini.eastday.com/mobile/180102082808680.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180102/20180102_942b1444072f1481301ca1dc3e0ed262_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180102/20180102_47a5c1ea7c4b1efa0f06abe5c218b2f5_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180102/20180102_e5aefab8b36117f51487290f9548183b_cover_mwpm_03200403.jpg"},{"uniquekey":"7cb47c6f2f2232f2f6656d4d618cf767","title":"\u201c世界屋脊\u201d 阳光照在壮丽如画的塔什库尔干","date":"2018-01-02 08:21","category":"头条","author_name":"国家地理中文网","url":"http://mini.eastday.com/mobile/180102082105082.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102082105_d41d8cd98f00b204e9800998ecf8427e_19_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180102/20180102082105_d41d8cd98f00b204e9800998ecf8427e_18_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180102/20180102082105_d41d8cd98f00b204e9800998ecf8427e_21_mwpm_03200403.jpg"},{"uniquekey":"715217bbf1b677bad454735bd29f2129","title":"日出东方\u2014\u2014 北京新机场主航站楼工程封顶封围","date":"2018-01-02 08:11","category":"头条","author_name":"人民网","url":"http://mini.eastday.com/mobile/180102081102767.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102081102_ae8955ec9a262a5d9f4165d45fae058a_5_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180102/20180102081102_c72df65ff67d41ce6f414d6baa022ce4_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180102/20180102081102_9cc1b62278761e0e834cf5dd0c2950e5_3_mwpm_03200403.jpg"},{"uniquekey":"516bcfbb9c266c4ca7a78f4b34dc847f","title":"元月一号过后运势瞬间变好三生肖，财源滚滚而来","date":"2018-01-02 08:10","category":"头条","author_name":"小诸葛风水命理","url":"http://mini.eastday.com/mobile/180102081040773.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180102/20180102_1b54cc5e50a43e6afcc2b2f6ed1c932f_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20180102/20180102_1925687836db77617d334d97b3360981_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20180102/20180102_21edcc727bfa9a6a6f4e1d36e7ab3fa1_cover_mwpm_03200403.jpg"},{"uniquekey":"675b5de698fb2c3a91f1ed176279da89","title":"2018年桃花开姻缘来1月份，真爱降临，喜事成双三大生肖","date":"2018-01-02 08:10","category":"头条","author_name":"小诸葛风水命理","url":"http://mini.eastday.com/mobile/180102081014556.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102_e01a848b2d176ae24dac9992c07246fe_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180102/20180102_072ef0b43ea5052186d43146b4d37c78_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180102/20180102_129a37ae378d946abf7ee9d64a8f117a_cover_mwpm_03200403.jpg"},{"uniquekey":"eb97efa24eb96754c4797228eed2a07c","title":"北京今起持续寒冷最低温仅有-8℃ 本周能见度佳","date":"2018-01-02 08:06","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/180102080655920.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180102/20180102080655_878ba8ebe32c759b3061f445746efea1_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180102/20180102080655_878ba8ebe32c759b3061f445746efea1_1_mwpm_03200403.jpg"},{"uniquekey":"fe7403db1a8da314fd39fadb09ee128f","title":"多部进口片登陆1月影市 \u201c绝地武士\u201d打头炮","date":"2018-01-02 08:06","category":"头条","author_name":"新华网","url":"http://mini.eastday.com/mobile/180102080606669.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102080606_ee43c799e4b8f9397b686636b66c3d8c_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180102/20180102080606_ee43c799e4b8f9397b686636b66c3d8c_7_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180102/20180102080606_ee43c799e4b8f9397b686636b66c3d8c_6_mwpm_03200403.jpg"},{"uniquekey":"b43f354a0e701ddb10759ea2ec6fdbac","title":"重庆\u2022江北第五届光猪跑暨全民健身迎新趣味活动开跑啦","date":"2018-01-02 08:04","category":"头条","author_name":"华龙网","url":"http://mini.eastday.com/mobile/180102080457465.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180102/20180102080457_92015896445bb030b82fec217f83dda3_1_mwpm_03200403.jpg"},{"uniquekey":"3d044a961ade61607b319dbf9603fd76","title":"扎心了！平均年入15.4万！我这几年在上海白混了！","date":"2018-01-02 08:03","category":"头条","author_name":"魔都上海","url":"http://mini.eastday.com/mobile/180102080354985.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180102/20180102080354_629887e910633bf06d952c42754320d8_11_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180102/20180102080354_21381a824533dcfc18c9db870075ede6_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180102/20180102080354_865e38b372629f858220ff2ab5a116d5_5_mwpm_03200403.jpg"},{"uniquekey":"9b4bc125e95fa739da7aa8e9feea80e7","title":"刚到退休年龄，只领了一个月养老的保险，人就去世了怎么办？","date":"2018-01-02 08:01","category":"头条","author_name":"IT产业网","url":"http://mini.eastday.com/mobile/180102080140820.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180102/20180102080140_344651e988de628c65813e0c3e22ec80_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180102/20180102080140_344651e988de628c65813e0c3e22ec80_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180102/20180102080140_344651e988de628c65813e0c3e22ec80_1_mwpm_03200403.jpg"}]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * stat : 1
         * data : [{"uniquekey":"0ee34f10926180b6f6e67175e57c10d8","title":"伦敦举行2018新年街头游行 美女街头载歌载舞","date":"2018-01-02 10:19","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102101920933.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102101920_0b43bdad201e8ba10e199ec7256cdb39_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180102/20180102101920_0b43bdad201e8ba10e199ec7256cdb39_10_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180102/20180102101920_0b43bdad201e8ba10e199ec7256cdb39_7_mwpm_03200403.jpg"},{"uniquekey":"5666908c809ec2b4a8a177678c87afed","title":"澳大利亚数百万只袋鼠神秘死亡 或感染疾病所致","date":"2018-01-02 10:19","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102101921738.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180102/20180102101921_f9156641fc820d2b8187e4a6f52f04e0_1_mwpm_03200403.jpg"},{"uniquekey":"bf7173ff9938355611704c2c5193ed4e","title":"新年伊始 法国巴黎大区公交建设发布新\u201c路线图\u201d","date":"2018-01-02 10:19","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102101921022.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102101921_d20c239f054ee53a1b0e3ce8fcc37d1d_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180102/20180102101921_d20c239f054ee53a1b0e3ce8fcc37d1d_2_mwpm_03200403.jpg"},{"uniquekey":"403c87c50687233c6b1fa1b151e6e65c","title":"鲁哈尼呼吁冷静未奏效 伊朗周一继续爆发示威游行","date":"2018-01-02 10:19","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102101920422.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180102/20180102101920_a6b2f9fd5de7caea70aa073c5c1e3ac3_1_mwpm_03200403.jpg"},{"uniquekey":"242b8694f113b706382f76ddf92aa4d9","title":"韩国总统文在寅赴显忠院参拜为新年祈愿","date":"2018-01-02 09:58","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102095844158.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102095844_5b64d1c3e375d8e374c7c614010318ef_1_mwpm_03200403.jpg"},{"uniquekey":"77432f09064b462989bdcff483ce0062","title":"2018上海落户政策，满足这些就可以轻松落户啦！","date":"2018-01-02 09:50","category":"头条","author_name":"上海本地宝","url":"http://mini.eastday.com/mobile/180102095008444.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102095008_66174ef95ac0c75bdec636de8c5423c7_1_mwpm_03200403.jpg"},{"uniquekey":"a3843f2a9cc2e0efe022034126ef7bef","title":"伊朗爆发抗议游行，不能一味地归咎于外部因素","date":"2018-01-02 09:48","category":"头条","author_name":"观察者网","url":"http://mini.eastday.com/mobile/180102094851757.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180102/20180102094851_264caed8878da6fedd41ab8d1f5b9355_1_mwpm_03200403.jpg"},{"uniquekey":"3a02ea6998a0155e4f1c563b38bdffe1","title":"马华裔男子因外形被女友抛弃 整成型男后感叹\u201c世界太现实\u201d","date":"2018-01-02 09:48","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102094815126.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180102/20180102094815_88bc19738d2e1524b2d6c8609f706806_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20180102/20180102094815_88bc19738d2e1524b2d6c8609f706806_1_mwpm_03200403.jpg"},{"uniquekey":"3098ad5efeaaa1df5cc5523c56c514f9","title":"文汇战略 | 特朗普鲁哈尼隔空互怼，西方推波助澜，伊朗持续示威会演变成\u201c颜色革命\u201d吗？","date":"2018-01-02 09:46","category":"头条","author_name":"文汇网","url":"http://mini.eastday.com/mobile/180102094633046.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180102/20180102094633_7d4adaa88ee9480bc6ae99e553a4ecfd_1_mwpm_03200403.jpg"},{"uniquekey":"09978c0ed06ac06b51dbc1970e7cb77d","title":"瑞士新《收养法》生效 同性恋获许收养继子","date":"2018-01-02 09:37","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102093759535.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180102/20180102093759_b5783b0330ab6adf1e9205ec07730b40_1_mwpm_03200403.jpg"},{"uniquekey":"c3ec57aeda58b519c3deab6a7192681b","title":"无人机之旅|2017爱上湖北的航拍在这儿","date":"2018-01-02 09:29","category":"头条","author_name":"新华网","url":"http://mini.eastday.com/mobile/180102092957459.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102092957_f1cc1f8bc7107fdf0e61cf2c3068dfd6_8_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180102/20180102092957_450b0a76919b96767ba28008dbe097f8_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180102/20180102092957_9433f5f4a95cfb531f7e881ab012111b_10_mwpm_03200403.jpg"},{"uniquekey":"d6d40cdd501084c7f010fadd8a26ec21","title":"好莱坞数百位大咖女性发声 关注劳工职场骚扰","date":"2018-01-02 09:27","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102092742696.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180102/20180102092742_10a100d78ec9b80fb1785dfd009adf45_1_mwpm_03200403.jpg"},{"uniquekey":"55f83a76f04d57070a74c2ff374891cd","title":"法国财长：法国有意建立从欧洲经莫斯科到北京的\u201c商路\u201d","date":"2018-01-02 09:17","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102091727777.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102091727_05df455fc4656a61c72757670307b434_1_mwpm_03200403.jpg"},{"uniquekey":"4022be0e1b4ed90ee8aa0adeb1df9731","title":"祖母留下的破毛毯卖到975万！他瞬间成富翁，亲戚却不干了","date":"2018-01-02 09:16","category":"头条","author_name":"看什么鬼","url":"http://mini.eastday.com/mobile/180102091602401.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102_4e15682d81a333e35f5e268442c7c315_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180102/20180102_968e8dc4683b4f72c93f8fd3e041a08a_cover_mwpm_03200403.jpg"},{"uniquekey":"33a5a6d9bb3a7f5968a55983dc05ccc6","title":"朝鲜释放善意，就看美国如何接招，如果一意孤行，将失去道义！","date":"2018-01-02 09:04","category":"头条","author_name":"第一军情","url":"http://mini.eastday.com/mobile/180102090442044.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102_ab3ab2f2f5f1ffd3912efdc9bf49eeb7_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180102/20180102_de4a8ab8928c9878abbf9d5f816892d2_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180102/20180102_770b40b40a40fa119974c83c988316ce_cover_mwpm_03200403.jpg"},{"uniquekey":"7e48395cb5aeab9128cf373e72646579","title":"菲利普亲王又失言 笑称\u201c大胡子男为恐怖分子\u201d","date":"2018-01-02 08:56","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102085650210.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180102/20180102085650_178d083b484f1ca24d7630be8fa7b00c_1_mwpm_03200403.jpg"},{"uniquekey":"e86ccf3fae8f6769a0b45082a0934cd1","title":"上海垃圾偷倒太湖的背后，是特大城市的\u201c垃圾围城\u201d","date":"2018-01-02 08:55","category":"头条","author_name":"凤凰社会","url":"http://mini.eastday.com/mobile/180102085550191.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102085550_2f049b230745990f71e04e937d25da29_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180102/20180102085550_2f049b230745990f71e04e937d25da29_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20180102/20180102085550_2f049b230745990f71e04e937d25da29_2_mwpm_03200403.jpg"},{"uniquekey":"ae09208a8402686f8f01ed227f5811fd","title":"早安海峡：蔡英文元旦升旗多\u201c独派\u201d抗议","date":"2018-01-02 08:35","category":"头条","author_name":"中国台湾网","url":"http://mini.eastday.com/mobile/180102083555911.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102083555_0c26c6c8f1502d7213afacbfd1e15c14_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180102/20180102083555_0c26c6c8f1502d7213afacbfd1e15c14_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180102/20180102083555_0c26c6c8f1502d7213afacbfd1e15c14_1_mwpm_03200403.jpg"},{"uniquekey":"7d5c73e0869c0135c8096d516a0a7315","title":"乔治娅-尼克斯1月1日至7日 本周星座运势","date":"2018-01-02 08:31","category":"头条","author_name":"Lonia占星","url":"http://mini.eastday.com/mobile/180102083106794.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102083106_ed3808c02cc8f7763084b9d5e7d8cb51_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180102/20180102083106_ed3808c02cc8f7763084b9d5e7d8cb51_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20180102/20180102083106_ed3808c02cc8f7763084b9d5e7d8cb51_5_mwpm_03200403.jpg"},{"uniquekey":"bd6ecad059bbb28dd7e056570aa10bf6","title":"和蛇相依的农村少女，如今活成可这样，让人心疼不已","date":"2018-01-02 08:29","category":"头条","author_name":"娱乐部落阁","url":"http://mini.eastday.com/mobile/180102082904620.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102_2d6dc975e4f6ae6d1f55412fb904c4d2_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180102/20180102_ec4f26f8417dfc7ea6091f9b1c9f9be5_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20180102/20180102_e61095ad6adff7f869278d0ec6a37774_cover_mwpm_03200403.jpg"},{"uniquekey":"7a933d9aa780732bba6acc78875c09b7","title":"半岛发生巨变！朝鲜刚刚以退为进，给特朗普最沉重一击","date":"2018-01-02 08:28","category":"头条","author_name":"大国军情","url":"http://mini.eastday.com/mobile/180102082808680.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180102/20180102_942b1444072f1481301ca1dc3e0ed262_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180102/20180102_47a5c1ea7c4b1efa0f06abe5c218b2f5_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180102/20180102_e5aefab8b36117f51487290f9548183b_cover_mwpm_03200403.jpg"},{"uniquekey":"7cb47c6f2f2232f2f6656d4d618cf767","title":"\u201c世界屋脊\u201d 阳光照在壮丽如画的塔什库尔干","date":"2018-01-02 08:21","category":"头条","author_name":"国家地理中文网","url":"http://mini.eastday.com/mobile/180102082105082.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102082105_d41d8cd98f00b204e9800998ecf8427e_19_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180102/20180102082105_d41d8cd98f00b204e9800998ecf8427e_18_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180102/20180102082105_d41d8cd98f00b204e9800998ecf8427e_21_mwpm_03200403.jpg"},{"uniquekey":"715217bbf1b677bad454735bd29f2129","title":"日出东方\u2014\u2014 北京新机场主航站楼工程封顶封围","date":"2018-01-02 08:11","category":"头条","author_name":"人民网","url":"http://mini.eastday.com/mobile/180102081102767.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102081102_ae8955ec9a262a5d9f4165d45fae058a_5_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180102/20180102081102_c72df65ff67d41ce6f414d6baa022ce4_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180102/20180102081102_9cc1b62278761e0e834cf5dd0c2950e5_3_mwpm_03200403.jpg"},{"uniquekey":"516bcfbb9c266c4ca7a78f4b34dc847f","title":"元月一号过后运势瞬间变好三生肖，财源滚滚而来","date":"2018-01-02 08:10","category":"头条","author_name":"小诸葛风水命理","url":"http://mini.eastday.com/mobile/180102081040773.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180102/20180102_1b54cc5e50a43e6afcc2b2f6ed1c932f_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20180102/20180102_1925687836db77617d334d97b3360981_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20180102/20180102_21edcc727bfa9a6a6f4e1d36e7ab3fa1_cover_mwpm_03200403.jpg"},{"uniquekey":"675b5de698fb2c3a91f1ed176279da89","title":"2018年桃花开姻缘来1月份，真爱降临，喜事成双三大生肖","date":"2018-01-02 08:10","category":"头条","author_name":"小诸葛风水命理","url":"http://mini.eastday.com/mobile/180102081014556.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102_e01a848b2d176ae24dac9992c07246fe_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180102/20180102_072ef0b43ea5052186d43146b4d37c78_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180102/20180102_129a37ae378d946abf7ee9d64a8f117a_cover_mwpm_03200403.jpg"},{"uniquekey":"eb97efa24eb96754c4797228eed2a07c","title":"北京今起持续寒冷最低温仅有-8℃ 本周能见度佳","date":"2018-01-02 08:06","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/180102080655920.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180102/20180102080655_878ba8ebe32c759b3061f445746efea1_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180102/20180102080655_878ba8ebe32c759b3061f445746efea1_1_mwpm_03200403.jpg"},{"uniquekey":"fe7403db1a8da314fd39fadb09ee128f","title":"多部进口片登陆1月影市 \u201c绝地武士\u201d打头炮","date":"2018-01-02 08:06","category":"头条","author_name":"新华网","url":"http://mini.eastday.com/mobile/180102080606669.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102080606_ee43c799e4b8f9397b686636b66c3d8c_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180102/20180102080606_ee43c799e4b8f9397b686636b66c3d8c_7_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180102/20180102080606_ee43c799e4b8f9397b686636b66c3d8c_6_mwpm_03200403.jpg"},{"uniquekey":"b43f354a0e701ddb10759ea2ec6fdbac","title":"重庆\u2022江北第五届光猪跑暨全民健身迎新趣味活动开跑啦","date":"2018-01-02 08:04","category":"头条","author_name":"华龙网","url":"http://mini.eastday.com/mobile/180102080457465.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180102/20180102080457_92015896445bb030b82fec217f83dda3_1_mwpm_03200403.jpg"},{"uniquekey":"3d044a961ade61607b319dbf9603fd76","title":"扎心了！平均年入15.4万！我这几年在上海白混了！","date":"2018-01-02 08:03","category":"头条","author_name":"魔都上海","url":"http://mini.eastday.com/mobile/180102080354985.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180102/20180102080354_629887e910633bf06d952c42754320d8_11_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180102/20180102080354_21381a824533dcfc18c9db870075ede6_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180102/20180102080354_865e38b372629f858220ff2ab5a116d5_5_mwpm_03200403.jpg"},{"uniquekey":"9b4bc125e95fa739da7aa8e9feea80e7","title":"刚到退休年龄，只领了一个月养老的保险，人就去世了怎么办？","date":"2018-01-02 08:01","category":"头条","author_name":"IT产业网","url":"http://mini.eastday.com/mobile/180102080140820.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180102/20180102080140_344651e988de628c65813e0c3e22ec80_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180102/20180102080140_344651e988de628c65813e0c3e22ec80_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180102/20180102080140_344651e988de628c65813e0c3e22ec80_1_mwpm_03200403.jpg"}]
         */

        private String stat;
        private List<DataBean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * uniquekey : 0ee34f10926180b6f6e67175e57c10d8
             * title : 伦敦举行2018新年街头游行 美女街头载歌载舞
             * date : 2018-01-02 10:19
             * category : 头条
             * author_name : 环球网
             * url : http://mini.eastday.com/mobile/180102101920933.html
             * thumbnail_pic_s : http://01.imgmini.eastday.com/mobile/20180102/20180102101920_0b43bdad201e8ba10e199ec7256cdb39_4_mwpm_03200403.jpg
             * thumbnail_pic_s02 : http://01.imgmini.eastday.com/mobile/20180102/20180102101920_0b43bdad201e8ba10e199ec7256cdb39_10_mwpm_03200403.jpg
             * thumbnail_pic_s03 : http://01.imgmini.eastday.com/mobile/20180102/20180102101920_0b43bdad201e8ba10e199ec7256cdb39_7_mwpm_03200403.jpg
             */

            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
        }
    }


    private void parse(){

        String json = "";

        Gson gson = new Gson();
        NewsMessageSource newsMessageSource = gson.fromJson(json,NewsMessageSource.class);

    }
}
