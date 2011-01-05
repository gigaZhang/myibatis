<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="keywords" content="上海生活排行榜|上海人气餐厅|上海最热门酒吧|上海最好的电影 院|上海KTV排行榜|生活指数|上海驾校排行榜"/>
<meta name="description" content="丁丁地图发布2010年度上海生活指数排行榜，提供上海地区各 种生活指数权威数字，及上海、杭州、南京三地搜索量最高商圈、地标、购物中心、公交地铁，让你在急 升的物价中精明消费！"/>
<title>丁丁时尚生活庆典---丁丁网</title>
<link href="vote_1215.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.1.js"></script>
<script type="text/javascript" src="js/jquery.thickbox.js"></script>
</head>
<body>
<div id="help" class="help">
 <table id="table">
<tr>
  <th width="60">投票：</th>
  <td>根据丁丁网搜索数据TOP100，选取美食、酒吧、电影院、婚纱摄影、游乐场、SPA、首饰珠宝、KTV、开车，9个分类排名前10商户入围。</td>
</tr>
 <tr>
  <th>颁奖：</th>
  <td>“丁丁网友上海最爱排行榜十大” 将获丁丁网颁发奖杯，并视频记录线下颁奖全程。</td>
</tr>
 </table>

</div>
<div id="body">
  <div class="header">
    <p>
    <img src="images/top.jpg" alt="丁丁时尚生活盛典" width="960" height="451" border="0" usemap="#Map" />
    <map name="Map" id="Map">
      <area shape="rect" coords="25,4,138,45" href="http://www.ddmap.com" target="_blank" alt="丁丁网" />
    </map>
    </p>
    <div class="menu">
      <ul class="menu1">
       <li><a href="http://ddmap.com" target="_blank">首页</a></li>
       <li>|</li>
      <li class="imgotherL"><a href="javascript:;" id="orl"><span class="boldL">频 道
       <img src="images/idxN_icon1.gif" width="5" height="3" alt=""/></span></a>
        <div id="HBk">
            <div class="HBk_bg">频 道</div>
            <div class="HBk">
              <div class="subb1 subk">
                <h2>生活</h2>
                <ul>
                  <li><a href="http://sh.food.ddmap.com/" target="_blank">美食</a></li>
                  <li><a href="http://sh.enjoy.ddmap.com/" target="_blank">娱乐休闲</a></li>
                  <li><a href="http://city.ddmap.com/" target="_blank">城市购物</a></li>
                  <li><a href="http://marry.ddmap.com/" target="_blank">结婚</a></li>
                  <li><a href="http://home.ddmap.com/" target="_blank">装修</a></li>
                  <li><a href="http://auto.ddmap.com/" target="_blank">爱车学车</a></li>
                </ul>
                <ul>
                  <li><a href="http://travel.ddmap.com/" target="_blank">旅游</a></li>
                  <li><a href="http://house.ddmap.com/" target="_blank">买房租房</a></li>
                  <li><a href="http://sh.hotel.ddmap.com/" target="_blank">酒店</a></li>
                  <li><a href="http://sh.class.ddmap.com/" target="_blank">培训</a></li>
                  <li><a href="http://sh.child.ddmap.com/" target="_blank">母婴医疗</a></li>
                </ul>
              </div>
              <div class="subb2 subk">
                <h2>丁丁旗下</h2>
                <ul>
                  <li><a href="http://www.ddmap.com/map/21/channel-bus.htm" target="_blank">公交开车</a></li>
                  <li><a href="http://city.ddmap.com/coupon/21/" target="_blank">优惠券</a></li>
                  <li><a href="http://bbs.ddmap.com/21/" target="_blank">盯盯社区</a></li>
                  <li><a href="http://wenba.ddmap.com/" target="_blank">丁丁问吧</a></li>
                  <li><a href="http://www.ddmap.com/mstmap50007/operation/" target="_blank">积分商城</a></li>
                  <li><a href="http://city.ddmap.com/ddcoupon/21/" target="_blank">丁丁乐活指南</a></li>
                </ul>
                <ul>
                  <li><a href="http://app.ddmap.com/huodong/" target="_blank">丁丁活动</a></li>
                </ul>
              </div>
              <div class="subb3 subk">
                <h2>更多</h2>
                <ul>
                  <li><a href="http://www.ddmap.com/mstmap50007/g_map_21.htm" target="_blank">地图</a></li>
                  <li><a href="http://app.ddmap.com/metro/index.jsp?mapId=21" target="_blank">地铁</a></li>
                  <li><a href="http://app.ddmap.com/shpolice/" target="_blank">电子警察</a></li>
                  <!--li><a href="http://ddclub.ddmap.com/topic/parking/index.jsp" target="_blank">停车场</a></li-->
                  <li><a href="http://www.ddmap.com/map/21/top-----.htm" target="_blank">生活指数排行榜</a></li>
                  <li><a href="http://www.ddmap.com/mstmap50007/helpcenter/hc_ddmap1.jsp" target="_blank">帮助中心</a></li>
                </ul>
              </div>
            </div>
        </div>
     </li>
        <li>|</li>
        <li><a href="http://tuan.ddmap.com" target="_blank">团购</a></li>
        <li>|</li>
        <li><a href="http://city.ddmap.com/coupon/?g_f=ddidx_nav_26" target="_blank">优惠券</a></li>
        <li>|</li>
        <li><a href="http://www.ddmap.com/mstmap50007/operation/?g_f=ddidx_nav_27" target="_blank">点评上海</a></li>
        <li>|</li>
        <li><a href="http://house.ddmap.com/?g_f=ddidx_nav_28" target="_blank">找房子</a></li>
      </ul>
      <ul class="menu2">
        <li><a href="http://www.ddmap.com/" target="_blank">丁丁首页</a></li>
        <li>|</li>
        <li><a href="http://user.ddmap.com/reg.jsp" target="_blank">注册</a></li>
        <li>|</li>
        <li><a href="http://www.ddmap.com/mstmap50007/operation/login.jsp" target="_blank">登陆</a></li>
      </ul>
    </div>
    <p class="header_p1"><span>投票说明：</span>点击选项投票，确认“提交”即可！若投票过程发生舞弊，主办方有权取消所得票数及评奖资格，并对相关人员追究法律责任。</p>
    <p class="header_p2"><span>投票有奖：</span>投票后，将“恭喜，提交成功”字样截图，发送至<a href="mailto:wujiani@ddmap.com">wujiani@ddmap.com</a>，即有机会获得丁丁网送出的超级新年礼物福袋！</p>
    <p class="header_p3"> <a href="#TB_inline?height=130&amp;width=330&amp;inlineId=help" id="thickImg"  class="thickbox" title="奖项说明">奖项说明&gt;&gt;</a></p>
 </div>
  <div class="content">
   <div class="form_top">
  <div class="form">
   <h2><img src="images/food_h2.jpg" width="294" height="44" alt="美食"/><span>最多可选三项</span></h2>
   <form method="post" action="">
   <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>商户</th>
       <th>票数</th>
       <th>投票</th>
     </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://www.ddmap.com/map/21/point-91144-%C4%F1%B0%B2-.htm" target="_blank">鸟安</a></td>
      <td>65484</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>2</td>
      <td><a href="http://www.ddmap.com/map/21/point-84330-%BA%A3%B5%D7-.htm" target="_blank">海底捞</a></td>
      <td>21154</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>3</td>
      <td><a href="http://www.ddmap.com/map/21/point-347556-%CB%D5%CE%E4-.htm" target="_blank">苏武牧羊</a></td>
      <td>15454</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>4</td>
      <td><a href="http://www.ddmap.com/map/21/point-348699-%B4%F3%D3%E6-.htm" target="_blank">大鱼铁板烧</a></td>
      <td>12154</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>5</td>
      <td><a href="http://www.ddmap.com/map/21/point-653454-%CC%C6%B9%AC-.htm" target="_blank">唐宫</a></td>
      <td>5454</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>6</td>
      <td><a href="http://www.ddmap.com/map/21/point-416882-%D0%C1%CF%E3-.htm" target="_blank">辛香汇</a></td>
      <td>5422</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>7</td>
      <td><a href="http://www.ddmap.com/map/21/point-347351-%C8%FD%C8%CB-.htm" target="_blank">三人行骨头王火锅</a></td>
      <td>5215</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>8</td>
      <td><a href="http://www.ddmap.com/map/21/point-346280-%B8%DB%C0%F6-.htm" target="_blank">港丽餐厅</a></td>
      <td>2154</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://www.ddmap.com/map/21/point-847208-%B7%E1%CA%D5-.htm" target="_blank">火辣餐厅</a></td>
      <td>1235</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://www.ddmap.com/map/21/point-348903-%B9%E3%D6%DD-.htm" target="_blank">广州蕉叶</a></td>
      <td>545</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
   </tbody>
   </table>
    <p>您的一票是最好的肯定<input type="submit" value="" class="submit"/></p>
   </form>
  </div>

   <div class="form">
    <h2><img src="images/bar_h2.jpg" width="294" height="44" alt="酒吧"/><span>最多可选三项</span></h2>
   <form method="post" action="">
   <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>商户</th>
       <th>票数</th>
       <th>投票</th>
     </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://www.ddmap.com/map/21/point-344046-%B0%C5%B0%C5-.htm" target="_blank">芭芭露莎</a></td>
      <td>65484</td>
      <td><input type="checkbox" name="bar" /></td>
     </tr>
     <tr>
      <td>2</td>
      <td><a href="http://www.ddmap.com/map/21/point-734436-HO-.htm" target="_blank">hoF</a></td>
      <td>21154</td>
      <td><input type="checkbox" name="bar" /></td>
     </tr>
     <tr>
      <td>3</td>
      <td><a href="http://www.ddmap.com/map/21/point-1052762-MU-.htm" target="_blank">MUSE CLUB</a></td>
      <td>15454</td>
      <td><input type="checkbox" name="bar" /></td>
     </tr>
     <tr>
      <td>4</td>
      <td><a href="http://www.ddmap.com/map/21/point-1056807-%E8%B4%C4%C8-.htm" target="_blank">璐娜LUNA</a></td>
      <td>12154</td>
      <td><input type="checkbox" name="bar" /></td>
     </tr>
     <tr>
      <td>5</td>
      <td><a href="http://www.ddmap.com/map/21/point-206739-Cl-.htm" target="_blank">Club G plus</a></td>
      <td>5454</td>
      <td><input type="checkbox" name="bar" /></td>
     </tr>
     <tr>
      <td>6</td>
      <td><a href="http://www.ddmap.com/map/21/point-344111-m@H@-.htm" target="_blank">m-box</a></td>
      <td>5422</td>
      <td><input type="checkbox" name="bar" /></td>
     </tr>
     <tr>
      <td>7</td>
      <td><a href="http://www.ddmap.com/map/21/point-1052880-%C0%B6%CD%DC-.htm" target="_blank">蓝蛙俱乐部</a></td>
      <td>5215</td>
      <td><input type="checkbox" name="bar" /></td>
     </tr>
     <tr>
      <td>8</td>
      <td><a href="http://www.ddmap.com/map/21/point-271601-%B9%D9%DB%A1-.htm" target="_blank">官邸酒吧</a></td>
      <td>2154</td>
      <td><input type="checkbox" name="bar" /></td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://www.ddmap.com/map/21/point-391432-%C8%F8%C9%AF-.htm" target="_blank">萨莎酒吧</a></td>
      <td>1235</td>
      <td><input type="checkbox" name="bar" /></td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://www.ddmap.com/map/21/point-344220-cl-.htm" target="_blank">cloud 9九重天酒廊</a></td>
      <td>545</td>
      <td><input type="checkbox" name="bar" /></td>
     </tr>
   </tbody>
   </table>
    <p>您的一票是最好的肯定<input type="submit" value="" class="submit"/></p>
   </form>
   </div>
 
   <div class="form">
    <h2><img src="images/movies_h2.jpg" width="294" height="44" alt="电影院"/><span>最多可选三项</span></h2>
   <form method="post" action="">
   <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>商户</th>
       <th>票数</th>
       <th>投票</th>
     </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://www.ddmap.com/map/21/point-343952-%BA%CD%C6%BD-.htm" target="_blank">和平影都</a></td>
      <td>65484</td>
      <td><input type="checkbox" name="movies" /></td>
     </tr>
     <tr>
      <td>2</td>
      <td><a href="http://www.ddmap.com/map/21/point-343983-%D3%C0%BB%AA-.htm" target="_blank">永华电影城</a></td>
      <td>21154</td>
      <td><input type="checkbox" name="movies" /></td>
     </tr>
     <tr>
      <td>3</td>
      <td><a href="http://www.ddmap.com/map/21/point-343948-%B4%F3%B9%E2-.htm" target="_blank">大光明电影院</a></td>
      <td>15454</td>
      <td><input type="checkbox" name="movies" /></td>
     </tr>
     <tr>
      <td>4</td>
      <td><a href="http://www.ddmap.com/map/21/point-2009222-%C9%CF%BA%A3-.htm" target="_blank">上海万达国际影城</a></td>
      <td>12154</td>
      <td><input type="checkbox" name="movies" /></td>
     </tr>
     <tr>
      <td>5</td>
      <td><a href="http://www.ddmap.com/map/21/point-422625-%CD%F2%D4%A3-.htm" target="_blank">万裕国际影城</a></td>
      <td>5454</td>
      <td><input type="checkbox" name="movies" /></td>
     </tr>
     <tr>
      <td>6</td>
      <td><a href="http://www.ddmap.com/map/21/point-343970-%C9%CF%BA%A3-.htm" target="_blank">上海影城</a></td>
      <td>5422</td>
      <td><input type="checkbox" name="movies" /></td>
     </tr>
     <tr>
      <td>7</td>
      <td><a href="http://www.ddmap.com/map/21/point-410743-%C1%FA%D6%AE-.htm" target="_blank">龙之梦影城</a></td>
      <td>5215</td>
      <td><input type="checkbox" name="movies" /></td>
     </tr>
     <tr>
      <td>8</td>
      <td><a href="http://www.ddmap.com/map/21/point-343943-UM-.htm" target="_blank">UME新天地国际影城</a></td>
      <td>2154</td>
      <td><input type="checkbox" name="movies" /></td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://www.ddmap.com/map/21/point-393995-%CA%C0%BC%CD-.htm" target="_blank">世纪大上海电影院</a></td>
      <td>1235</td>
      <td><input type="checkbox" name="movies" /></td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://www.ddmap.com/map/21/point-425773-%C9%CF%BA%A3-.htm" target="_blank">上海电影院</a></td>
      <td>545</td>
      <td><input type="checkbox" name="movies" /></td>
     </tr>
   </tbody>
   </table>
    <p>您的一票是最好的肯定<input type="submit" value="" class="submit"/></p>
   </form>
   </div>
  
   <div class="form">
    <h2><img src="images/marry_h2.jpg" width="294" height="44" alt="婚纱摄影"/><span>最多可选三项</span></h2>
   <form method="post" action="">
   <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>商户</th>
       <th>票数</th>
       <th>投票</th>
     </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://marry.ddmap.com/companys/697.htm" target="_blank">天星精品婚纱摄影</a></td>
      <td>65484</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>2</td>
      <td><a href="http://marry.ddmap.com/company/895.htm" target="_blank">古摄影</a></td>
      <td>21154</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>3</td>
      <td><a href="http://marry.ddmap.com/companys/428.htm" target="_blank">桔子摄影</a></td>
      <td>15454</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>4</td>
      <td><a href="http://marry.ddmap.com/companys/437.htm" target="_blank">蔚蓝海岸</a></td>
      <td>12154</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>5</td>
      <td><a href="http://marry.ddmap.com/companys/988.htm" target="_blank">ID摄影</a></td>
      <td>5454</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>6</td>
      <td><a href="http://marry.ddmap.com/companys/1159.htm" target="_blank">汤肯婚纱摄影</a></td>
      <td>5422</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>7</td>
      <td><a href="http://marry.ddmap.com/companys/823.htm" target="_blank">黄河视觉</a></td>
      <td>5215</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>8</td>
      <td><a href="http://marry.ddmap.com/companys/387.htm" target="_blank">爱摄影</a></td>
      <td>2154</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://marry.ddmap.com/companys/430.htm" target="_blank">贝拉摄影</a></td>
      <td>1235</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://marry.ddmap.com/companys/703.htm" target="_blank">品微摄影</a></td>
      <td>545</td>
      <td><input type="checkbox" name="marry" /></td>
     </tr>
   </tbody>
   </table>
    <p>您的一票是最好的肯定<input type="submit" value="" class="submit"/></p>
   </form>
   </div>
 
   <div class="form">
    <h2><img src="images/play_h2.jpg" width="294" height="44" alt="游乐场"/><span>最多可选三项</span></h2>
   <form method="post" action="">
   <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>商户</th>
       <th>票数</th>
       <th>投票</th>
     </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://www.ddmap.com/map/21/point-720601-%C9%CF%BA%A3-.htm" target="_blank">欢乐谷</a></td>
      <td>65484</td>
      <td><input type="checkbox" name="play" /></td>
     </tr>
     <tr>
      <td>2</td>
      <td><a href="http://www.ddmap.com/map/21/point-22227-%BD%F5%BD%AD-.htm" target="_blank">锦江乐园</a></td>
      <td>21154</td>
      <td><input type="checkbox" name="play" /></td>
     </tr>
     <tr>
      <td>3</td>
      <td><a href="http://www.ddmap.com/map/21/point-557167-%B6%AB%B7%BD-.htm" target="_blank">东方绿舟</a></td>
      <td>15454</td>
      <td><input type="checkbox" name="play" /></td>
     </tr>
     <tr>
      <td>4</td>
      <td><a href="http://www.ddmap.com/map/21/point-244728-%CC%C0%C4%B7-.htm" target="_blank">汤姆熊</a></td>
      <td>12154</td>
      <td><input type="checkbox" name="play" /></td>
     </tr>
     <tr>
      <td>5</td>
      <td><a href="http://www.ddmap.com/map/21/point-382809-%D0%C2%CA%C0-.htm" target="_blank">世纪世嘉游艺天地</a></td>
      <td>5454</td>
      <td><input type="checkbox" name="play" /></td>
     </tr>
     <tr>
      <td>6</td>
      <td><a href="http://www.ddmap.com/map/21/point-1052911-%C4%CF%C3%CE-.htm" target="_blank">新南梦宫电子游戏世界</a></td>
      <td>5422</td>
      <td><input type="checkbox" name="play" /></td>
     </tr>
     <tr>
      <td>7</td>
      <td><a href="http://www.ddmap.com/map/21/point-683458-%B0%AE%C0%D6-.htm" target="_blank">爱乐游</a></td>
      <td>5215</td>
      <td><input type="checkbox" name="play" /></td>
     </tr>
     <tr>
      <td>8</td>
      <td><a href="http://www.ddmap.com/map/21/point-248111-%BE%AA%C9%F9-.htm" target="_blank">惊声尖叫黑暗迷宫</a></td>
      <td>2154</td>
      <td><input type="checkbox" name="play" /></td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://www.ddmap.com/map/21/point-778411-%BF%A8%CD%A8-.htm" target="_blank">卡通尼儿童乐园</a></td>
      <td>1235</td>
      <td><input type="checkbox" name="play" /></td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://www.ddmap.com/map/21/point-814864-%C3%C0%B9%FA-.htm" target="_blank">美国黑匣子鬼屋</a></td>
      <td>545</td>
      <td><input type="checkbox" name="play" /></td>
     </tr>
   </tbody>
   </table>
    <p>您的一票是最好的肯定<input type="submit" value="" class="submit"/></p>
   </form>
   </div>

   <div class="form">
    <h2><img src="images/spa_h2.jpg" width="294" height="44" alt="SPA"/><span>最多可选三项</span></h2>
   <form method="post" action="">
   <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>商户</th>
       <th>票数</th>
       <th>投票</th>
     </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://www.ddmap.com/map/chain-2166-%C0%F6%E5%FB%D1%C5%BC%AF.htm" target="_blank">丽妍雅集</a></td>
      <td>65484</td>
      <td><input type="checkbox" name="spa" /></td>
     </tr>
     <tr>
      <td>2</td>
      <td><a href="http://www.ddmap.com/map/21/point-302018-GR-.htm" target="_blank">GREEN MASSAGE</a></td>
      <td>21154</td>
      <td><input type="checkbox" name="spa" /></td>
     </tr>
     <tr>
      <td>3</td>
      <td><a href="http://www.ddmap.com/map/21/point-94907-%BF%CB%C0%F6-.htm" target="_blank">克丽缇娜国际美容中心</a></td>
      <td>15454</td>
      <td><input type="checkbox" name="spa" /></td>
     </tr>
     <tr>
      <td>4</td>
      <td><a href="http://www.ddmap.com/map/21/point-815026-%B1%B4%DC%BD-.htm" target="_blank">贝芙丽国际美容中心SPA</a></td>
      <td>12154</td>
      <td><input type="checkbox" name="spa" /></td>
     </tr>
     <tr>
      <td>5</td>
      <td><a href="http://www.ddmap.com/map/21/point-793585-%B0%C5%D9%B3-.htm" target="_blank">芭俪伊人spa养生馆</a></td>
      <td>5454</td>
      <td><input type="checkbox" name="spa" /></td>
     </tr>
     <tr>
      <td>6</td>
      <td><a href="http://www.ddmap.com/map/21/point-714774-%C1%AB%BA%C9-.htm" target="_blank">莲荷泰集SPA养生馆</a></td>
      <td>5422</td>
      <td><input type="checkbox" name="spa" /></td>
     </tr>
     <tr>
      <td>7</td>
      <td><a href="http://www.ddmap.com/map/21/point-711448-%B0%DB%B2%DD-.htm" target="_blank">佰草集SPA养生馆</a></td>
      <td>5215</td>
      <td><input type="checkbox" name="spa" /></td>
     </tr>
     <tr>
      <td>8</td>
      <td><a href="http://www.ddmap.com/map/21/point-717850-%CB%AE%BE%B3-.htm" target="_blank">柏悦酒店水境SPA</a></td>
      <td>2154</td>
      <td><input type="checkbox" name="spa" /></td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://www.ddmap.com/map/21/point-652487-in-.htm" target="_blank">in one spa</a></td>
      <td>1235</td>
      <td><input type="checkbox" name="spa" /></td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://www.ddmap.com/map/21/point-582379-%D2%C0%D4%C6-.htm" target="_blank">依云水疗EvinaSpa</a></td>
      <td>545</td>
      <td><input type="checkbox" name="spa" /></td>
     </tr>
   </tbody>
   </table>
    <p>您的一票是最好的肯定<input type="submit" value="" class="submit"/></p>
   </form>
   </div>

   <div class="form">
    <h2><img src="images/jewelry_h2.jpg" width="294" height="44" alt="首饰珠宝"/><span>最多可选三项</span></h2>
   <form method="post" action="">
   <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>商户</th>
       <th>票数</th>
       <th>投票</th>
     </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://marry.ddmap.com/company/1007.htm" target="_blank">乐钻珠宝</a></td>
      <td>65484</td>
      <td><input type="checkbox" name="jewelry" /></td>
     </tr>
     <tr>
      <td>2</td>
      <td><a href="http://marry.ddmap.com/companys/912.htm" target="_blank">九钻</a></td>
      <td>21154</td>
      <td><input type="checkbox" name="jewelry" /></td>
     </tr>
     <tr>
      <td>3</td>
      <td><a href="http://marry.ddmap.com/company/1036.htm" target="_blank">珂兰</a></td>
      <td>15454</td>
      <td><input type="checkbox" name="jewelry" /></td>
     </tr>
     <tr>
      <td>4</td>
      <td><a href="http://marry.ddmap.com/companys/868.htm" target="_blank">洪福</a></td>
      <td>12154</td>
      <td><input type="checkbox" name="jewelry" /></td>
     </tr>
     <tr>
      <td>5</td>
      <td><a href="http://marry.ddmap.com/companys/1023.htm" target="_blank">福泰</a></td>
      <td>5454</td>
      <td><input type="checkbox" name="jewelry" /></td>
     </tr>
     <tr>
      <td>6</td>
      <td><a href="http://www.ddmap.com/map/21/point-693083-%D7%EA%CA%AF-.htm" target="_blank">钻石小鸟</a></td>
      <td>5422</td>
      <td><input type="checkbox" name="jewelry" /></td>
     </tr>
     <tr>
      <td>7</td>
      <td><a href="http://marry.ddmap.com/companys/914.htm" target="_blank">威德钻石</a></td>
      <td>5215</td>
      <td><input type="checkbox" name="jewelry" /></td>
     </tr>
     <tr>
      <td>8</td>
      <td><a href="http://marry.ddmap.com/companys/990.htm" target="_blank">铂爵钻石</a></td>
      <td>2154</td>
      <td><input type="checkbox" name="jewelry" /></td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://marry.ddmap.com/company/920.htm" target="_blank">DE珠宝</a></td>
      <td>1235</td>
      <td><input type="checkbox" name="jewelry" /></td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://marry.ddmap.com/companys/1006.htm" target="_blank">爱芙德</a></td>
      <td>545</td>
      <td><input type="checkbox" name="jewelry" /></td>
     </tr>
   </tbody>
   </table>
    <p>您的一票是最好的肯定<input type="submit" value="" class="submit"/></p>
   </form>
   </div>

   <div class="form">
    <h2><img src="images/htv_h2.jpg" width="294" height="44" alt="KTV"/><span>最多可选三项</span></h2>
   <form method="post" action="">
   <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>商户</th>
       <th>票数</th>
       <th>投票</th>
     </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://www.ddmap.com/map/21/point-391445-%C7%AE%B9%F1-.htm" target="_blank">钱柜KTV</a></td>
      <td>65484</td>
      <td><input type="checkbox" name="ktv" /></td>
     </tr>
     <tr>
      <td>2</td>
      <td><a href="http://www.ddmap.com/map/21/point-2011372-%BA%C3%C0%D6-.htm" target="_blank">好乐迪量贩KTV</a></td>
      <td>21154</td>
      <td><input type="checkbox" name="ktv" /></td>
     </tr>
     <tr>
      <td>3</td>
      <td><a href="http://www.ddmap.com/map/21/point-280413-%C9%CF%BA%A3-.htm" target="_blank">上海歌城量贩式KTV</a></td>
      <td>15454</td>
      <td><input type="checkbox" name="ktv" /></td>
     </tr>
     <tr>
      <td>4</td>
      <td><a href="http://www.ddmap.com/map/21/point-372614-%C2%F3%C0%D6-.htm" target="_blank">麦乐迪KTV</a></td>
      <td>12154</td>
      <td><input type="checkbox" name="ktv" /></td>
     </tr>
     <tr>
      <td>5</td>
      <td><a href="http://www.ddmap.com/map/21/point-372615-%F7%E8%F7%EB-.htm" target="_blank">麒麟音乐城</a></td>
      <td>5454</td>
      <td><input type="checkbox" name="ktv" /></td>
     </tr>
     <tr>
      <td>6</td>
      <td><a href="http://www.ddmap.com/map/21/point-78534-%D1%C7%C2%FC-.htm" target="_blank">亚曼达KTV</a></td>
      <td>5422</td>
      <td><input type="checkbox" name="ktv" /></td>
     </tr>
     <tr>
      <td>7</td>
      <td><a href="http://www.ddmap.com/map/21/point-814895-%DF%E9%B8%E8-.htm" target="_blank">唛歌时尚KTV</a></td>
      <td>5215</td>
      <td><input type="checkbox" name="ktv" /></td>
     </tr>
     <tr>
      <td>8</td>
      <td><a href="http://www.ddmap.com/map/21/point-372634-%D3%C5%C5%C9-.htm" target="_blank">优派试听歌城</a></td>
      <td>2154</td>
      <td><input type="checkbox" name="ktv" /></td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://www.ddmap.com/map/21/point-741528-Fa-.htm" target="_blank">Fame卡拉OK会所</a></td>
      <td>1235</td>
      <td><input type="checkbox" name="ktv" /></td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://www.ddmap.com/map/21/point-343990-%B1%D8%B0%AE-.htm" target="_blank">必爱歌</a></td>
      <td>545</td>
      <td><input type="checkbox" name="ktv" /></td>
     </tr>
   </tbody>
   </table>
    <p>您的一票是最好的肯定<input type="submit" value="" class="submit"/></p>
   </form>
   </div>
  
   <div class="form">
    <h2><img src="images/car_h2.jpg" width="294" height="44" alt="开车"/><span>最多可选三项</span></h2>
   <form method="post" action="">
   <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>商户</th>
       <th>票数</th>
       <th>投票</th>
     </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://auto.ddmap.com/toDetail.do?companyId=867&g_f=AUTOIDX_LB" target="_blank">荣荣团队</a></td>
      <td>65484</td>
      <td><input type="checkbox" name="car" /></td>
     </tr>
     <tr>
      <td>2</td>
      <td><a href="http://auto.ddmap.com/toDetail.do?companyId=1092&g_f=AUTOIDX_LB" target="_blank">徐明良团队</a></td>
      <td>21154</td>
      <td><input type="checkbox" name="car" /></td>
     </tr>
     <tr>
      <td>3</td>
      <td><a href="http://auto.ddmap.com/toDetail.do?companyId=602&g_f=AUTOIDX_LB" target="_blank">集结号团队</a></td>
      <td>15454</td>
      <td><input type="checkbox" name="car" /></td>
     </tr>
     <tr>
      <td>4</td>
      <td><a href="http://auto.ddmap.com/toDetail.do?companyId=1120&g_f=AUTOIDX_LB" target="_blank">光明荣伟团队</a></td>
      <td>12154</td>
      <td><input type="checkbox" name="car" /></td>
     </tr>
     <tr>
      <td>5</td>
      <td><a href="http://auto.ddmap.com/toDetail.do?companyId=553&g_f=AUTOIDX_LB" target="_blank">阮慧民团队</a></td>
      <td>5454</td>
      <td><input type="checkbox" name="car" /></td>
     </tr>
     <tr>
      <td>6</td>
      <td><a href="http://auto.ddmap.com/toDetail.do?companyId=869&g_f=AUTOIDX_LB" target="_blank">沪南驾校周浦分队</a></td>
      <td>5422</td>
      <td><input type="checkbox" name="car" /></td>
     </tr>
     <tr>
      <td>7</td>
      <td><a href="http://auto.ddmap.com/toDetail.do?companyId=605&g_f=AUTOIDX_LB" target="_blank">蔡敏杰师傅团队</a></td>
      <td>5215</td>
      <td><input type="checkbox" name="car" /></td>
     </tr>
     <tr>
      <td>8</td>
      <td><a href="http://auto.ddmap.com/toDetail.do?companyId=1133&g_f=AUTOIDX_LB" target="_blank">小鱼儿团队</a></td>
      <td>2154</td>
      <td><input type="checkbox" name="car" /></td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://auto.ddmap.com/toDetail.do?companyId=1132&g_f=AUTOIDX_LB" target="_blank">新宇团队</a></td>
      <td>1235</td>
      <td><input type="checkbox" name="car" /></td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://auto.ddmap.com/toDetail.do?companyId=1179&g_f=AUTOIDX_LB" target="_blank">上海申通驾驶员培训...</a></td>
      <td>545</td>
      <td><input type="checkbox" name="car" /></td>
     </tr>
   </tbody>
   </table>
    <p>您的一票是最好的肯定<input type="submit" value="" class="submit"/></p>
   </form>
    </div>
    <div class="clear"></div>

   </div>

   <div class="city">
    <h2><img src="images/shanghai_h2.jpg" width="916" height="38" alt="上海"/><span>2010年度丁丁地图搜索上海地区最热门排行</span></h2>
    <div>
   <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>商圈</th>
       <th>搜索量/次</th>
       </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://www.ddmap.com/map/21/point-329134-%c9%cf%ba%a3-.htm" target="_blank">八佰伴</a></td>
      <td>38748</td>
      </tr>
     <tr>
     <td>2</td>
      <td><a href="http://www.ddmap.com/map/21/point-558031-%C8%CB%C3%F1-.htm" target="_blank">人民广场</a></td>
      <td>30228</td>
     </tr>
     <tr>
     <td>3</td>
      <td><a href="http://www.ddmap.com/map/21/point-435690-%B3%C7%DA%F2-.htm" target="_blank">城隍庙</a></td>
      <td>30156</td>
     </tr>
     <tr>
     <td>4</td>
      <td><a href="http://www.ddmap.com/map/21/point-395619-%C6%DF%C6%D6-.htm" target="_blank">七浦路</a></td>
      <td>29412</td>
     </tr>
     <tr>
     <td>5</td>
      <td><a href="http://www.ddmap.com/map/21/point-24085-%CE%E5%BD%C7-.htm" target="_blank">五角场</a></td>
      <td>22284</td>
     </tr>
     <tr>
     <td>6</td>
      <td><a href="http://www.ddmap.com/map/21/point-239858-%C6%DF%B1%A6-.htm" target="_blank">七宝</a></td>
      <td>20196</td>
     </tr>
     <tr>
     <td>7</td>
      <td><a href="http://www.ddmap.com/map/21/point-22150-%B3%A4%B7%E7-.htm" target="_blank">长风公园</a></td>
      <td>16104</td>
     </tr>
     <tr>
     <td>8</td>
      <td><a href="http://www.ddmap.com/map/21/point-22295-%CA%C0%BC%CD-.htm" target="_blank">世纪公园</a></td>
      <td>15372</td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://www.ddmap.com/map/21/point-24303-%D0%C2%CC%EC-.htm" target="_blank">新天地</a></td>
      <td>15084</td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://www.ddmap.com/map/21/point-23249-%BE%B2%B0%B2-.htm" target="_blank">静安寺</a></td>
      <td>10404</td>
     </tr>
   </tbody>
   </table>
  
    <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>地标</th>
       <th>搜索量/次</th>
       </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://www.ddmap.com/map/21/point-821754-%BA%E7%C7%C5-.htm" target="_blank">虹桥火车站</a></td>
      <td>100668</td>
      </tr>
     <tr>
     <td>2</td>
      <td><a href="http://www.ddmap.com/map/21/point-34336-%C9%CF%BA%A3-.htm" target="_blank">上海南站</a></td>
      <td>52140</td>
     </tr>
     <tr>
     <td>3</td>
      <td><a href="http://www.ddmap.com/map/21/point-34334-%C9%CF%BA%A3-.htm" target="_blank">上海火车站</a></td>
      <td>15168</td>
     </tr>
     <tr>
     <td>4</td>
      <td><a href="http://www.ddmap.com/map/21/point-331398-%B8%B4%B5%A9-.htm" target="_blank">复旦大学</a></td>
      <td>10104</td>
     </tr>
     <tr>
     <td>5</td>
      <td><a href="http://www.ddmap.com/map/21/point-22357-%D4%A5%D4%B0-.htm" target="_blank">豫园</a></td>
      <td>9516</td>
     </tr>
     <tr>
     <td>6</td>
      <td><a href="http://www.ddmap.com/map/21/point-642266-%C3%C0%C2%DE-.htm" target="_blank">美罗城</a></td>
      <td>8172</td>
     </tr>
     <tr>
     <td>7</td>
      <td><a href="http://www.ddmap.com/map/21/point-16016-%C9%CF%BA%A3-.htm" target="_blank">光大会展中心</a></td>
      <td>7800</td>
     </tr>
     <tr>
     <td>8</td>
      <td><a href="http://www.ddmap.com/map/21/point-329195-%BE%C3%B9%E2-.htm" target="_blank">久光百货</a></td>
      <td>6276</td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://www.ddmap.com/map/21/point-331308-%C9%CF%BA%A3-.htm" target="_blank">上海师范大学</a></td>
      <td>4752</td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://www.ddmap.com/map/21/point-22201-%BA%CD%C6%BD-.htm" target="_blank">和平公园</a></td>
      <td>4704</td>
     </tr>
   </tbody>
   </table>
    <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>购物中心</th>
       <th>搜索量/次</th>
       </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://www.ddmap.com/map/21/point-227198-%C6%D6%B6%AB-.htm" target="_blank">大拇指广场</a></td>
      <td>34068</td>
      </tr>
     <tr>
     <td>2</td>
      <td><a href="http://www.ddmap.com/map/21/point-329302-%B0%D9%C1%AA-.htm" target="_blank">南方商城</a></td>
      <td>33732</td>
     </tr>
     <tr>
     <td>3</td>
      <td><a href="http://www.ddmap.com/map/21/point-16571-%CF%E3%B8%DB-.htm" target="_blank">香港广场</a></td>
      <td>14772</td>
     </tr>
     <tr>
     <td>4</td>
      <td><a href="http://www.ddmap.com/map/21/point-635895-%CD%F2%B4%EF-.htm" target="_blank">万达广场</a></td>
      <td>14052</td>
     </tr>
     <tr>
     <td>5</td>
      <td><a href="http://www.ddmap.com/map/21/point-1054524-%B0%D9%C1%AA-.htm" target="_blank">中环百联购物</a></td>
      <td>13164</td>
     </tr>
     <tr>
     <td>6</td>
      <td><a href="http://www.ddmap.com/map/21/point-329113-%C9%CF%BA%A3-.htm" target="_blank">上海百盛购物中心</a></td>
      <td>12120</td>
     </tr>
     <tr>
     <td>7</td>
      <td><a href="http://www.ddmap.com/map/21/point-329291-%C9%CF%BA%A3-.htm" target="_blank">新世界百货</a></td>
      <td>10620</td>
     </tr>
     <tr>
     <td>8</td>
      <td><a href="http://www.ddmap.com/map/21/point-425905-%C0%B4%B8%A3-.htm" target="_blank">来福士</a></td>
      <td>9536</td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://www.ddmap.com/map/21/point-89097-%C2%BD%BC%D2-.htm" target="_blank">96广场</a></td>
      <td>9564</td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://www.ddmap.com/map/21/point-329181-%BB%E3%BD%F0-.htm" target="_blank">汇金百货</a></td>
      <td>8316</td>
     </tr>
   </tbody>
   </table>
     <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>公交地铁</th>
       <th>搜索量/次</th>
       </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://www.ddmap.com/map/21/point-50020635-%B5%D8%CC%FA-.htm" target="_blank">地铁10号线</a></td>
      <td>101052</td>
      </tr>
     <tr>
     <td>2</td>
      <td><a href="http://www.ddmap.com/map/21/point-50018280-%B5%D8%CC%FA-.htm" target="_blank">地铁7号线</a></td>
      <td>38772</td>
     </tr>
     <tr>
     <td>3</td>
      <td><a href="http://www.ddmap.com/map/21/point-35251-%B5%D8%CC%FA-.htm" target="_blank">地铁2号线</a></td>
      <td>36672</td>
     </tr>
     <tr>
     <td>4</td>
      <td><a href="http://www.ddmap.com/map/21/point-387796-%B5%D8%CC%FA-.htm" target="_blank">地铁9号线</a></td>
      <td>30468</td>
     </tr>
     <tr>
     <td>5</td>
      <td><a href="http://www.ddmap.com/map/21/point-438296-%B5%D8%CC%FA-.htm" target="_blank">地铁4号线</a></td>
      <td>16440</td>
     </tr>
     <tr>
     <td>6</td>
      <td><a href="http://www.ddmap.com/map/21/point-35253-%B5%D8%CC%FA-.htm" target="_blank">地铁3号线</a></td>
      <td>11964</td>
     </tr>
     <tr>
     <td>7</td>
      <td><a href="http://www.ddmap.com/map/21/point-22059333-%B5%D8%CC%FA-.htm" target="_blank">地铁8号线</a></td>
      <td>9504</td>
     </tr>
     <tr>
     <td>8</td>
      <td><a href="http://www.ddmap.com/map/21/point-35249-%B5%D8%CC%FA-.htm" target="_blank">地铁1号线</a></td>
      <td>8340</td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://www.ddmap.com/map/21/point-398720-%DD%B7%C4%CF-.htm" target="_blank">莘南线路线</a></td>
      <td>8016</td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://www.ddmap.com/map/21/point-50018613-%B5%D8%CC%FA-.htm" target="_blank">地铁11号线</a></td>
      <td>7608</td>
     </tr>
   </tbody>
   </table>
    </div>
    <p><img src="images/city_bottom.jpg" width="916" height="9" alt=""/></p>
   </div>
   <!--上海 end-->
  <!--杭州-->
   <div class="city">
    <h2><img src="images/hangzhou_h2.jpg" width="916" height="38" alt="杭州"/><span>2010年度丁丁地图搜索上海地区最热门排行</span></h2>
    <div>
   <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>商圈</th>
       <th>搜索量/次</th>
       </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://hz.ddmap.com/map/571/point-821283-%B0%D9%C1%AA-.htm" target="_blank">奥特莱斯下沙店</a></td>
      <td>33360</td>
      </tr>
     <tr>
     <td>2</td>
      <td><a href="http://hz.ddmap.com/map/571/point-230141-%D4%CB%BA%D3-.htm" target="_blank">运河广场</a></td>
      <td>5304</td>
     </tr>
     <tr>
     <td>3</td>
      <td><a href="http://hz.ddmap.com/map/571/point-483073-%C2%A5%CD%E2-.htm" target="_blank">西湖区楼外楼饭店</a></td>
      <td>5124</td>
     </tr>
     <tr>
     <td>4</td>
      <td><a href="http://hz.ddmap.com/map/571/point-658484-%BA%D3%B7%BB-.htm" target="_blank">杭州清河坊步行街</a></td>
      <td>4428</td>
     </tr>
     <tr>
     <td>5</td>
      <td><a href="http://hz.ddmap.com/map/571/point-791394-%BF%AA%D4%AA-.htm" target="_blank">萧山加州阳光广场</a></td>
      <td>3756</td>
     </tr>
     <tr>
     <td>6</td>
      <td><a href="http://hz.ddmap.com/map/571/point-840990-%D0%C2%BC%D3-.htm" target="_blank">下沙新加坡科技园</a></td>
      <td>3072</td>
     </tr>
     <tr>
     <td>7</td>
      <td><a href="http://hz.ddmap.com/map/571/point-708256-%BA%BC%D6%DD-.htm" target="_blank">萧山极地海底世界</a></td>
      <td>2700</td>
     </tr>
     <tr>
     <td>8</td>
      <td><a href="http://hz.ddmap.com/map/571/point-641319-%BA%BC%D6%DD-.htm" target="_blank">西溪数码港</a></td>
      <td>2268</td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://hz.ddmap.com/map/571/point-485082-%CE%E2%C9%BD-.htm" target="_blank">银泰百货吴山广场</a></td>
      <td>1380</td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://hz.ddmap.com/map/571/point-486795-%C1%E9%D2%FE-.htm" target="_blank">西湖灵隐寺</a></td>
      <td>1332</td>
     </tr>
   </tbody>
   </table>
    <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>地标</th>
       <th>搜索量/次</th>
       </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://hz.ddmap.com/map/571/point-304091-%B0%D9%C4%D4-.htm" target="_blank">百脑汇电脑市场</a></td>
      <td>16440</td>
      </tr>
     <tr>
     <td>2</td>
      <td><a href="http://hz.ddmap.com/map/571/point-487501-%CE%F7%B3%C7-.htm" target="_blank">杭州西城广场</a></td>
      <td>3708</td>
     </tr>
     <tr>
     <td>3</td>
      <td><a href="http://hz.ddmap.com/map/571/point-490908-%C0%FB%D0%C7-.htm" target="_blank">利星名品广场</a></td>
      <td>2760</td>
     </tr>
     <tr>
     <td>4</td>
      <td><a href="http://hz.ddmap.com/map/571/point-861233-%CA%A4%C0%FB-.htm" target="_blank">胜利河美食街</a></td>
      <td>2700</td>
     </tr>
     <tr>
     <td>5</td>
      <td><a href="http://hz.ddmap.com/map/571/point-485881-%CE%F7%BA%FE-.htm" target="_blank">西湖时代广场</a></td>
      <td>1728</td>
     </tr>
     <tr>
     <td>6</td>
      <td><a href="http://hz.ddmap.com/map/571/point-226068-%D5%E3%BD%AD-.htm" target="_blank">工业大学</a></td>
      <td>1608</td>
     </tr>
     <tr>
     <td>7</td>
      <td><a href="http://hz.ddmap.com/map/571/point-485110-%D3%BF%BD%F0-.htm" target="_blank">涌金广场</a></td>
      <td>1428</td>
     </tr>
     <tr>
     <td>8</td>
      <td><a href="http://hz.ddmap.com/map/571/point-490907-%BD%E2%B0%D9-.htm" target="_blank">杭州解百新世纪</a></td>
      <td>1224</td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://hz.ddmap.com/map/571/point-205229-%BA%BC%D6%DD-.htm" target="_blank">杭州大厦</a></td>
      <td>1128</td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://hz.ddmap.com/map/571/point-28812-%D0%C5%D2%E5-.htm" target="_blank">信义坊</a></td>
      <td>1044</td>
     </tr>
   </tbody>
   </table>
    <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>购物中心</th>
       <th>搜索量/次</th>
       </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://hz.ddmap.com/map/571/point-29667-%BA%BC%D6%DD-.htm" target="_blank">万象城购物中心</a></td>
      <td>17508</td>
      </tr>
     <tr>
     <td>2</td>
      <td><a href="http://hz.ddmap.com/map/571/point-230141-%D4%CB%BA%D3-.htm" target="_blank">运河广场</a></td>
      <td>7068</td>
     </tr>
     <tr>
     <td>3</td>
      <td><a href="http://hz.ddmap.com/map/571/point-821283-%B0%D9%C1%AA-.htm" target="_blank">下沙百联奥特莱斯</a></td>
      <td>7032</td>
     </tr>
     <tr>
     <td>4</td>
      <td><a href="http://hz.ddmap.com/map/571----%CE%F7%BA%FE%D2%F8%CC%A9---1-coup/" target="_blank">西湖银泰</a></td>
      <td>4200</td>
     </tr>
     <tr>
     <td>5</td>
      <td><a href="http://hz.ddmap.com/map/571/point-413899-%CB%C4%BC%BE-.htm" target="_blank">四季青服装市场</a></td>
      <td>3720</td>
     </tr>
     <tr>
     <td>6</td>
      <td><a href="http://hz.ddmap.com/map/571/point-765111-%D6%D0%B6%BC-.htm" target="_blank">中都百货庆春店</a></td>
      <td>3276</td>
     </tr>
     <tr>
     <td>7</td>
      <td><a href="http://hz.ddmap.com/map/571/point-785084-%D3%A1%CF%F3-.htm" target="_blank">印象城购物中心</a></td>
      <td>2664</td>
     </tr>
     <tr>
     <td>8</td>
      <td><a href="http://hz.ddmap.com/map/571----%BA%BC%D6%DD%B9%FA%B4%F3%C9%CC%B3%A1---1-coup/" target="_blank">杭州国大商场</a></td>
      <td>1620</td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://hz.ddmap.com/map/571/point-205229-%BA%BC%D6%DD-.htm" target="_blank">杭州大厦购物中心</a></td>
      <td>1236</td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://hz.ddmap.com/map/571/point-29667-%BA%BC%D6%DD-.htm" target="_blank">万象城商场</a></td>
      <td>1044</td>
     </tr>
   </tbody>
   </table>
    <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>公交地铁</th>
       <th>搜索量/次</th>
       </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://hz.ddmap.com/map/571/point-832716-%BA%BC%D6%DD-.htm" target="_blank">九堡客运中心站</a></td>
      <td>46368</td>
      </tr>
     <tr>
     <td>2</td>
      <td><a href="http://hz.ddmap.com/map/571/point-487529-%BA%BC%D6%DD-.htm" target="_blank">杭州火车南站</a></td>
      <td>12264</td>
     </tr>
     <tr>
     <td>3</td>
      <td><a href="http://hz.ddmap.com/map/571/bus-b%D6%A73.htm" target="_blank">B支3公交车</a></td>
      <td>12000</td>
     </tr>
     <tr>
     <td>4</td>
      <td><a href="http://hz.ddmap.com/map/571/bus-k76.htm" target="_blank">76路公交车</a></td>
      <td>11304</td>
     </tr>
     <tr>
     <td>5</td>
      <td><a href="http://hz.ddmap.com/map/571/bus-27.htm" target="_blank">27路公交车</a></td>
      <td>7596</td>
     </tr>
     <tr>
     <td>6</td>
      <td><a href="http://hz.ddmap.com/map/571/point-22104128-56-.htm" target="_blank">566公交线路</a></td>
      <td>7512</td>
     </tr>
     <tr>
     <td>7</td>
      <td><a href="http://hz.ddmap.com/map/571/point-50005355-k3-.htm" target="_blank">356路公交车</a></td>
      <td>5448</td>
     </tr>
     <tr>
     <td>8</td>
      <td><a href="http://hz.ddmap.com/map/571/bus-k101.htm" target="_blank">101路公交车</a></td>
      <td>4620</td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://hz.ddmap.com/map/571/bus-10.htm" target="_blank">10路公交车</a></td>
      <td>3552</td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://hz.ddmap.com/map/571/bus-290.htm" target="_blank">290路公交车</a></td>
      <td>3396</td>
     </tr>
   </tbody>
   </table>
    
    </div>
    <p><img src="images/city_bottom.jpg" width="916" height="9" alt=""/></p>
   </div>
   <!--杭州 end-->
    <!--南京-->
   <div class="city">
    <h2><img src="images/nanjing_h2.jpg" width="916" height="38" alt="南京"/><span>2010年度丁丁地图搜索上海地区最热门排行</span></h2>
    <div>
   <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>商圈</th>
       <th>搜索量/次</th>
       </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://nj.ddmap.com/map/25/point-507322-%D0%C2%BD%D6-.htm" target="_blank">新街口</a></td>
      <td>8472</td>
      </tr>
     <tr>
     <td>2</td>
      <td><a href="http://nj.ddmap.com/map/25/point-251107-%BA%FE%C4%CF-.htm" target="_blank">湖南路</a></td>
      <td>7752</td>
     </tr>
     <tr>
     <td>3</td>
      <td><a href="http://nj.ddmap.com/map/25/point-226260-%BD%AD%C4%FE-.htm" target="_blank">江宁大学城</a></td>
      <td>3048</td>
     </tr>
     <tr>
     <td>4</td>
      <td><a href="http://nj.ddmap.com/map/25/point-271571-%D0%FE%CE%E4-.htm" target="_blank">玄武湖</a></td>
      <td>2568</td>
     </tr>
     <tr>
     <td>5</td>
      <td><a href="http://nj.ddmap.com/map/25/point-830167-%D3%EA%BB%A8-.htm" target="_blank">雨花台</a></td>
      <td>2280</td>
     </tr>
     <tr>
     <td>6</td>
      <td><a href="http://nj.ddmap.com/map/25/point-203156-%BD%F0%C8%F3-.htm" target="_blank">瑞金路</a></td>
      <td>2208</td>
     </tr>
     <tr>
     <td>7</td>
      <td><a href="http://nj.ddmap.com/map/25/point-507329-%D6%D0%D1%EB-.htm" target="_blank">中央门</a></td>
      <td>2100</td>
     </tr>
     <tr>
     <td>8</td>
      <td><a href="http://nj.ddmap.com/map/25----%BD%AD%C4%FE---1-coup/" target="_blank">江宁</a></td>
      <td>1764</td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://nj.ddmap.com/map/25/point-507327-%D6%D0%BB%AA-.htm" target="_blank">中华门</a></td>
      <td>1572</td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://nj.ddmap.com/map/25----%C9%BD%CE%F7%C2%B7---1-coup/" target="_blank">山西路</a></td>
      <td>1392</td>
     </tr>
   </tbody>
   </table>
    <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>地标</th>
       <th>搜索量/次</th>
       </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://nj.ddmap.com/map/25/point-50024567-%BB%FA%B3%A1-.htm" target="_blank">机场大巴南京站</a></td>
      <td>16368</td>
      </tr>
     <tr>
     <td>2</td>
      <td><a href="http://nj.ddmap.com/map/25/point-2013011-%D0%C2%CA%C0-.htm" target="_blank">新世纪广场</a></td>
      <td>14568</td>
     </tr>
     <tr>
     <td>3</td>
      <td><a href="http://nj.ddmap.com/map/25/point-20017311-%B7%F2%D7%D3-.htm" target="_blank">夫子庙</a></td>
      <td>7092</td>
     </tr>
     <tr>
     <td>4</td>
      <td><a href="http://nj.ddmap.com/map/25/point-519614-%C4%CF%BE%A9-.htm" target="_blank">南京火车站</a></td>
      <td>5280</td>
     </tr>
     <tr>
     <td>5</td>
      <td><a href="http://nj.ddmap.com/map/25/point-278366-%B8%F0%CC%C1-.htm" target="_blank">南京葛塘汽车站</a></td>
      <td>4644</td>
     </tr>
     <tr>
     <td>6</td>
      <td><a href="http://nj.ddmap.com/map/25/point-1052537-%C1%FA%BD%AD-.htm" target="_blank">南京新城市广场</a></td>
      <td>3768</td>
     </tr>
     <tr>
     <td>7</td>
      <td><a href="http://nj.ddmap.com/map/25/point-508187-%BA%BA%D6%D0-.htm" target="_blank">汉中门汽车站</a></td>
      <td>3696</td>
     </tr>
     <tr>
     <td>8</td>
      <td><a href="http://nj.ddmap.com/map/25/point-390751-%BD%AD%C4%FE-.htm" target="_blank">南京江宁客运站</a></td>
      <td>3240</td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://nj.ddmap.com/map/25/point-507239-%BD%AB%BE%FC-.htm" target="_blank">将军山旅游风景区</a></td>
      <td>3168</td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://nj.ddmap.com/map/25/point-20017193-%D6%D0%C9%BD-.htm" target="_blank">中山陵</a></td>
      <td>3024</td>
     </tr>
   </tbody>
   </table>
    <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>购物中心</th>
       <th>搜索量/次</th>
       </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://nj.ddmap.com/map/25/point-783534-%C4%CF%BE%A9-.htm" target="_blank">河西万达广场</a></td>
      <td>12528</td>
      </tr>
     <tr>
     <td>2</td>
      <td><a href="http://nj.ddmap.com/map/25/point-22058584-%D0%C2%CA%C0-.htm" target="_blank">新世界百货</a></td>
      <td>8592</td>
     </tr>
     <tr>
     <td>3</td>
      <td><a href="http://nj.ddmap.com/map/25/point-776395-%BD%F0%D3%A5-.htm" target="_blank">仙林金鹰</a></td>
      <td>8568</td>
     </tr>
     <tr>
     <td>4</td>
      <td><a href="http://nj.ddmap.com/map/25/point-76686-%BD%F0%C2%D6-.htm" target="_blank">金轮新天地</a></td>
      <td>7164</td>
     </tr>
     <tr>
     <td>5</td>
      <td><a href="http://nj.ddmap.com/map/25/point-712707-%CF%C8%B7%E6-.htm" target="_blank">南京奥特莱斯商场</a></td>
      <td>5112</td>
     </tr>
     <tr>
     <td>6</td>
      <td><a href="http://nj.ddmap.com/map/25/point-825696-%B0%AE%B6%F9-.htm" target="_blank">南京爱儿时代商场</a></td>
      <td>4824</td>
     </tr>
     <tr>
     <td>7</td>
      <td><a href="http://nj.ddmap.com/map/25/point-728850-%BD%F0%D3%A5-.htm" target="_blank">汉中门金鹰特惠</a></td>
      <td>4620</td>
     </tr>
     <tr>
     <td>8</td>
      <td><a href="http://nj.ddmap.com/map/25/point-1052495-%B6%AB%B7%BD-.htm" target="_blank">东方商城</a></td>
      <td>4236</td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://nj.ddmap.com/map/25/point-1052493-%B4%F3%D1%F3-.htm" target="_blank">大洋百货</a></td>
      <td>3876</td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://nj.ddmap.com/map/25/point-507561-%CC%AB%C6%BD-.htm" target="_blank">太平洋百货</a></td>
      <td>3372</td>
     </tr>
   </tbody>
   </table>
    <table>
   <thead>
     <tr>
       <th>排行</th>
       <th>公交地铁</th>
       <th>搜索量/次</th>
       </tr>
   </thead>
   <tbody>
     <tr>
      <td>1</td>
      <td><a href="http://nj.ddmap.com/map/25/point-50021530-%B5%D8%CC%FA-.htm" target="_blank">南京地铁二号线</a></td>
      <td>51396</td>
      </tr>
     <tr>
     <td>2</td>
      <td><a href="http://nj.ddmap.com/map/25/point-513954-%B5%D8%CC%FA-.htm" target="_blank">南京地铁一号线</a></td>
      <td>37164</td>
     </tr>
     <tr>
     <td>3</td>
      <td><a href="http://nj.ddmap.com/map/25/point-513918-13-.htm" target="_blank">公交站点132</a></td>
      <td>4776</td>
     </tr>
     <tr>
     <td>4</td>
      <td><a href="http://nj.ddmap.com/map/25/point-50021531-%B5%D8%CC%FA-.htm" target="_blank">地铁南延线站点</a></td>
      <td>4056</td>
     </tr>
     <tr>
     <td>5</td>
      <td><a href="http://nj.ddmap.com/map/25/point-513909-10-.htm" target="_blank">100路公交车</a></td>
      <td>3084</td>
     </tr>
     <tr>
     <td>6</td>
      <td><a href="http://nj.ddmap.com/map/25/point-50002880-%BB%FA%B3%A1-.htm" target="_blank">瑞金路机场大巴</a></td>
      <td>2700</td>
     </tr>
     <tr>
     <td>7</td>
      <td><a href="http://nj.ddmap.com/map/25/point-50004663-13-.htm" target="_blank">136区间公交站</a></td>
      <td>2268</td>
     </tr>
     <tr>
     <td>8</td>
      <td><a href="http://nj.ddmap.com/map/25/point-2009767-%D3%CE4-.htm" target="_blank">游4路线</a></td>
      <td>2100</td>
     </tr>
     <tr>
      <td>9</td>
      <td><a href="http://nj.ddmap.com/map/25/point-50021828-%C6%D6%BC%AF-.htm" target="_blank">浦集线</a></td>
      <td>2040</td>
     </tr>
     <tr>
      <td>10</td>
      <td><a href="http://nj.ddmap.com/map/25/point-50017851-D1-.htm" target="_blank">D1线公交车</a></td>
      <td>1836</td>
     </tr>
   </tbody>
   </table>
    </div>
    <p><img src="images/city_bottom.jpg" width="916" height="9" alt=""/></p>
   </div>
   <!--南京 end-->
  </div>
  <div class="footer">
       <ul class="footer1">
         <li class="ddsh">丁丁生活</li>
         <li class="ddqx">丁丁旗下</li>
         <li>更多服务</li>
        </ul>
        <div class="footer2"> 
           <ul>
            <li><a target="_blank" href="http://sh.food.ddmap.com?g_f=ddidx_ha_1">美食</a></li>
            <li><a target="_blank" href="http://sh.enjoy.ddmap.com?g_f=ddidx_ha_2">娱乐休闲</a></li>
            <li><a target="_blank" href="http://city.ddmap.com?g_f=ddidx_ha_3">城市购物</a></li>
            <li><a target="_blank" href="http://marry.ddmap.com?g_f=ddidx_ha_4">结婚</a></li>
           </ul>
           <ul>
            <li><a target="_blank" href="http://home.ddmap.com?g_f=ddidx_ha_5">装修</a></li>
            <li><a target="_blank" href="http://auto.ddmap.com?g_f=ddidx_ha_6">爱车学车</a></li>
            <li><a target="_blank" href="http://travel.ddmap.com?g_f=ddidx_ha_7">旅游</a></li>
            <li><a target="_blank" href="http://house.ddmap.com?g_f=ddidx_ha_8">买房租房</a></li>
           </ul>
           <ul>
            <li><a target="_blank" href="http://sh.hotel.ddmap.com?g_f=ddidx_ha_9">酒店</a></li>
            <li><a target="_blank" href="http://sh.class.ddmap.com?g_f=ddidx_ha_10">培训</a></li>
            <li><a target="_blank" href="http://sh.child.ddmap.com/?g_f=ddidx_ha_11">母婴医疗</a></li>
           </ul>
       
           <ul>
              <li><a target="_blank" href="http://www.ddmap.com/map/21/channel-bus.htm?g_f=ddidx_ha_12"> 公交开车</a></li>
              <li><a target="_blank" href="http://city.ddmap.com/coupon/21/?g_f=ddidx_ha_13">优惠券</a></li>
              <li><a target="_blank" href="http://bbs.ddmap.com/21/?g_f=ddidx_ha_14"> 丁丁社区</a></li>
              <li><a target="_blank" href="http://wenba.ddmap.com/?g_f=ddidx_ha_15">丁丁问吧</a></li>
           </ul>
           <ul>
            <li><a target="_blank" href="http://www.ddmap.com/mstmap50007/operation/ddmall.jsp?g_f=ddidx_ha_16">积分商城</a></li>
            <li><a target="_blank" href="http://topic.ddmap.com/dm/?g_f=ddidx_ha_17">丁丁乐活指南</a></li>
            <li><a target="_blank" href="http://www.ddmap.com/mstmap50007/operation/?g_f=ddidx_ha_18">点评上海</a></li>
           </ul>

           <ul class="gdfw">
            <li><a target="_blank" href="http://www.ddmap.com/mstmap50007/g_map_21.htm?g_f=ddidx_ha_19">地图</a></li>
            <li><a target="_blank" href="http://app.ddmap.com/metro/index.jsp?mapId=21&amp;g_f=ddidx_ha_20">地铁</a></li>
            <li><a target="_blank" href="http://app.ddmap.com/shpolice/">电子警察</a></li>
            <li><a target="_blank" href="http://www.ddmap.com/map/21/top-----.htm">生活指数排行榜</a></li>
           </ul>
        </div>
        <div class="clear"></div>
        
        <ul class="footer6">
           <li>
             <a target="_blank" href="http://www.ddmap.com">丁丁网</a> |
             <a target="_blank" href="http://about.ddmap.com/contactus.htm">联系我们</a> |
             <a target="_blank" href="http://about.ddmap.com/">关于我们</a> |
             <a target="_blank" href="http://crm.ddmap.com/crm_cust/">客户登录</a> |
             <a target="_blank" href="http://www.ddmap.com/mstmap50007/wap_intro.jsp">wap服务</a> |
             <a target="_blank" href="http://www.ddmap.com/link-21.htm">友情链接</a> |
             <a target="_blank" href="http://www.ddmap.com/mstmap50007/helpcenter/index.jsp">帮助中心</a> |
             <a target="_blank" href="http://www.ddmap.com/mstmap50007/in_userjc1.jsp#yjfk">意见反馈</a> |
             <!-- <a href='/mstmap50007/in_userjc1.jsp#yjfk' target='_blank'>意见反馈</a> | -->
             <a target="_blank" href="http://www.ddmap.com/sitemap/21/1.htm">网站地图</a>
           </li>
           <li class="label">沪ICP证：沪B2-20070030沪ICP备10008907号<img width="15" height="17" alt="" src="http://www.ddmap.com/mstmap50007/images/foot_icon.gif" />&copy;2005-2010 DDMap
           <img width="55" height="21" alt="" src="http://www.ddmap.com/mstmap50007/images/foot_110.gif" /></li>
		   <li style="margin-top: 5px;"><a target="_blank" href="http://www.ddmap.com/mstmap50007/g_adv_loc.jsp?cname=A-T1&amp;pic=1&amp;ctype=A&amp;mapno=21&amp;curl=http://www.shcois.net/"><img alt="上海网络社会征信网" src="http://img1.ddmapimg.com/adv/idx_gaj.jpg" /></a></li>
        </ul> 
	  </div>
</div>
<script type="text/javascript">
    function $d(obj){var arg=document.getElementById(obj);return arg;}
	$d("orl").onmouseover=function(){$d("HBk").style.display="block";}
	$d("orl").onmouseout=function(){$d("HBk").style.display="none";}
	$d("HBk").onmouseout=function(){this.style.display="none";}
	$d("HBk").onmouseover=function(){this.style.display="block";} 
	$('table tr td:first-child').css('text-align','center');
	$('table tr th:first-child').next().css('text-align','left');
	$('table tr th:first-child').next().css('text-indent','5px')
	$('table tr td:first-child').next().css('text-indent','5px');
	$('table tr td:first-child').next().next().css('text-align','center');
	$('div.form table tr td:last-child').css('text-align','center');
    $("table").not('table#table').each(function(){
      $(this).find("tr:odd").css('background', '#FEF6E3');
	  $(this).find("tr:even").css('background', '#F5E7CD');
    });
  </script>
<script src='http://js.ddmap.com/js/stat.js' type="text/javascript"></script>
<SCRIPT language='JavaScript'>pv('smapno=21&stype=T&skey1=SHSD&skey2=I');</SCRIPT>
</body>
</html>
