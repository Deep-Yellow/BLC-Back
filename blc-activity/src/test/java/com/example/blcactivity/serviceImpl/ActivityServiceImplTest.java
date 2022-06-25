package com.example.blcactivity.serviceImpl;

import com.example.blcactivity.po.ActivityPO;
import com.example.blcactivity.vo.ActivityGroupVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ActivityServiceImplTest {

    @Autowired
    ActivityServiceImpl activityService;

//    @Test
//    void Test1(){
//        String title="软件研发效能实验室获2021年江苏省重点研发计划（产业前瞻与关键核心技术）拟立项目支持";
//        String content="<div class=\"content\">\n" +
//                "          <p><br></p><p style=\"text-indent: 2em;\"><br></p><p style=\"text-indent: 2em;\">6月8日，江苏省科技厅网站公示了2021年江苏省重点研发计划（产业前瞻与关键核心技术）拟立项目，南京大学与中诚区块链研究院、东南大学共同承担的《面向先进制造供应链的高性能区块链关键技术与服务平台研发》作为拟立重点项目名列其中。该拟立项的江苏省重点研发计划重点项目是2020年立项并启动的由南京大学张贺教授科研团队主持承担的国家首批区块链重点研发计划重点专项——《面向供应链的高性能区块链系统支撑平台关键技术研究》项目结合江苏省先进制造业的产业优势和重点发展方向的拓展延伸。</p><p><br></p><p style=\"text-indent: 2em;\">张贺教授科研团队主持承担项目课题《面向先进制造供应链领域的区块链系统架构设计方法和支持技术研究》。本课题拟从面向特定领域的区块链系统体系结构设计和在此基础之上的应用开发支持等层面展开系统化研究，探索先进制造业供应链系统的高可定制架构设计解决方案，包括区块链供应链系统的结构设计范式、最佳实践和评估方法，在此基础上研究领域驱动的供应链区块链系统的开发支持技术和平台，帮助领域相关人员快速且高质量地进行系统设计和构建。本课题还将研究智能合约的微服务化开发运维方法和相应的支持平台，旨在结合DevOps技术提升智能合约的持续部署、交付和高可扩展性。最后，本课题将研究并实现一套完善的基于联盟链的高性能异构多链桥接融合机制，解决先进制造供应链业务场景中异构多链共识验证和异构数据互联互通问题。</p><p><br></p><p style=\"text-align:center;\"><img src=\"/DFS//wordimp/gdc//xyxw/i202388/image1.png\" width=\"567\" height=\"344\" style=\"width: 567px; height: 344px;\"></p><p style=\"text-align:center;\"><span style=\"font-size:9.0pt;\">面向先进制造业供应链的区块链系统流程示意图</span></p><p><br></p><p style=\"text-indent: 2em;\">据悉，今年江苏省重点研发计划拟立项项目共136项，其中重点项目仅16项。《面向先进制造供应链的高性能区块链关键技术与服务平台研发》作为此次江苏省重点研发计划重点项目中唯一区块链领域重大专项，也是江苏省重点研<span id=\"_GoBack\">发计划历史上首个区块链重点项目。软件学院张贺教授科研团队将与项目其他课题负责单位中诚区块链研究院、东南大学，以及江苏沙钢集团、徐州工程机械集团、江苏省现代供应链协会等参与单位的科研团队通力协作，力争在关键创新指标上形成原创性、高水平代表性成果，达到国际先进水平；基于区块链技术重点攻关突破江苏先进制造\"卡脖子\"重大关键核心技术，推动一批江苏先进制造业提质增效，形成\"双链融合\"示范应用，提升江苏省\"双链融合\"的技术体系和标准体系，提升江苏省在先进制造业供应链中的国际话语权和竞争力。</span></p><p><br></p><p><br></p><p><br></p><p><br></p>\n" +
//                "        </div>";
//        ActivityPO activityPO=new ActivityPO();
//        activityPO.setContent(content);
//        activityPO.setPoster("https://software.nju.edu.cn/DFS//wordimp/gdc//xyxw/i202388/image1.png");
//        activityPO.setTitle(title);
//        activityPO.setTime("2021-06-15");
//        activityPO.setClassify("承接项目");
//        activityPO.setViews(0);
//        activityService.saveOrUpdate(activityPO);
//    }
//
//    @Test
//    void Test2(){
//        String title="国家重点研发计划重点专项项目——“面向供应链的高性能区块链系统支撑平台关键技术研究”正式启动";
//        String content="<div class=\"content\"><p style=\"text-indent:21.0pt;\"><br style=\"text-align: left;\"></p><p style=\"text-align: left; text-indent: 0em;\"><span id=\"OLE_LINK1\"><span id=\"OLE_LINK2\">&nbsp; &nbsp; &nbsp; &nbsp;区块链技术应用已延伸到数字金融、物联网、智能制造、供应链管理、数字资产交易等多个领域。目前，全球主要国家都在加快布局区块链技术发展。2019年10月24日，中共中央政治局就区块链技术发展现状和趋势进行第十八次集体学习。习近平总书记主持学习时强调，\"区块链技术的集成应用在新的技术革新和产业变革中起着重要作用。我们要把区块链作为<span style=\"font-weight:bold;color:#ff0000;\">核心技术自主创新</span>的重要突破口，明确主攻方向，加大投入力度，着力攻克一批关键核心技术，加快推动区块链技术和产业创新发展。\"</span></span></p><p style=\"text-align: left; text-indent: 0em;\"><br></p><p style=\"text-align: left; text-indent: 0em;\"><span id=\"OLE_LINK3\"><span id=\"OLE_LINK4\">&nbsp; &nbsp; &nbsp; &nbsp;2020年7月1日，由软件学院张贺教授科研团队主持承担的国家重点研发计划国际科技创新合作重点专项\"面向供应链的高性能区块链系统支撑平台关键技术研究\"项目正式启动。</span></span></p><p style=\"text-align: left; text-indent: 0em;\"><br></p><p style=\"text-align: left; text-indent: 0em;\">&nbsp; &nbsp; &nbsp; &nbsp;该项目由中国、挪威两国4所高校和5家企业共同参与，成员单位包括南京大学，挪威科技大学（NTNU）、清华大学、东南大学、星环信息科技公司、贵阳翼帆金融科技有限公司、挪威科学和工业研究基金会（SINTEF）、挪威船级社（DNV GL）和赫尔迈斯渔业有限公司（HERMES AS）。参与该项目的高校和企业之间在项目涉及领域有着很强的互补性，其中南京大学的软件研发效能（DevOps+）实验室在软件体系结构、开发运维一体化等方面有极为深厚的研究积累。</p><p style=\"text-align: left; text-indent: 0em;\"><br></p><p style=\"text-align: left; text-indent: 0em;\">&nbsp; &nbsp; &nbsp; &nbsp;该项目针对跨境供应链数据及交易难以追踪、缺乏信任及信用保证机制等问题，从数据存储与管理、体系架构设计、可信属性保障等几个方面，研究面向跨境供应链管理的高性能、高可信联盟链设计的关键技术，并构建高效开发与运维供应链区块链应用的支撑平台。该项目中南京大学科研团队重点负责异构区块链跨链融合技术、智能合约微服务化开发技术、领域驱动的区块链应用体系结构设计方法等研究内容。</p><p><br style=\"text-align: left;\"></p><p style=\"text-align:center\"><img src=\"/njdx/DFS//wordimp/qp2//xyxw/i113390/image1.png\" width=\"488\" height=\"309\" style=\"width: 488px; height: 309px;\"></p><p><br></p><p style=\"text-align: left; text-indent: 0em;\">&nbsp; &nbsp; &nbsp; &nbsp;作为国家重点研发计划首批区块链技术研发项目，该项目的科研成果将通过创新的技术、方法、工具和系统原型为区块链核心技术和平台做出贡献，促进区块链理论、技术发展，提升我国在国际区块链领域的话语权和规则制定权。项目成果的落地应用将满足国家一带一路供应链溯源的重大战略需求，特别是将对食品安全、质量产生积极影响。</p><p style=\"text-align: left; text-indent: 0em;\"><br></p><p style=\"text-align: left; text-indent: 0em;\"><br></p><p style=\"text-align: left; text-indent: 0em;\"><br></p></div>";
//        ActivityPO activityPO=new ActivityPO();
//        activityPO.setContent(content);
//        activityPO.setPoster("https://software.nju.edu.cn/njdx/DFS//wordimp/qp2//xyxw/i113390/image1.png");
//        activityPO.setTitle(title);
//        activityPO.setTime("2020-07-05");
//        activityPO.setClassify("承接项目");
//        activityPO.setViews(0);
//        activityService.saveOrUpdate(activityPO);
//    }

    @Test
    void Test4(){
        String title="第一阶段项目总结会议";
        String content="<div class=\"content-body\"><div class=\"container\"><div class=\"row\"><main class=\"col-md-12\"><div class=\"entry-content clearfix\"><p style=\"text-indent: 36px;\">项目中方单位的第一阶段会议于2021年1月8日下午2点在南京大学举行，考虑到疫情的最新情况，本次会议依然按照项目中方启动会的形式采用线上+线下组织，南京/上海各单位在南大线下参会，因北京疫情近期的波动清华大学仍线上参会，挪威方项目负责人李京悦老师及其他参与单位代表（华人）线上参加交流讨论。</p><div class=\"my-img-box\" style=\"text-align:center;\">    <img class=\"my-img-scale60\" src=\"http://124.222.93.55:8000/img/event1.JPG\" style=\"width: 567px; height: 344px;\">    <div class=\"my-img-title\">线下会议现场</div></div><p style=\"text-indent: 36px;\">    交流内容：第一阶段所负责/参与任务的进展情况和存在的问题，第二阶段（2021年1-6月份）的计划，需要与其他单位的协调及合作。</p></div></main></div></div></div>";
        ActivityPO activityPO=new ActivityPO();
        activityPO.setContent(content);
        activityPO.setPoster("http://124.222.93.55:8000/img/event1.JPG");
        activityPO.setTitle(title);
        activityPO.setTime("2021-01-08");
        activityPO.setClassify("中挪合作项目");
        activityPO.setViews(0);
        activityService.saveOrUpdate(activityPO);
    }

    @Test
    void Test5(){
        String title="第二阶段项目总结会议";
        String content="<div class=\"entry-content clearfix\"><p style=\"text-indent: 36px;\">项目的第二阶段项目总结会议于2021年7月6日举行。</p><p style=\"text-indent: 36px;\">交流内容：第一阶段所负责/参与任务的进展情况和存在的问题，第二阶段（2021年1-6月份）的计划，需要与其他单位的协调及合作。</p></div>";
        ActivityPO activityPO=new ActivityPO();
        activityPO.setContent(content);
        activityPO.setPoster("http://124.222.93.55:8000/img/event2.JPG");
        activityPO.setTitle(title);
        activityPO.setTime("2021-07-06");
        activityPO.setClassify("中挪合作项目");
        activityPO.setViews(0);
        activityService.saveOrUpdate(activityPO);
    }

    @Test
    void Test7(){
        String title="中期及第三阶段项目总结会议";
        String content="<style>h3{text-align: center;}</style><div class=\"container\"><div class=\"row\"><div class=\"entry-content clearfix with-indent\"><p>项目的中期及第三阶段总结会于2022年1月13日举行。项目各任务进展总结及成果展示如下：</p><h3 class=\"my-list-title\">应用场景分析、原型开发和验证（中诚）</h3><ul class=\"my-list\"><li>冷链应用场景调研，分为监管部门和企业两个角色</li><li>对江苏冷链和浙冷链进行调研</li><li>总结demo开发方案</li><li>NB-IOT温湿度记录仪的调研</li><li>对数据存储的设计</li><li>区块链产品溯源管理系统与软著申请</li><li>集成了智能合约检测</li></ul><h3 class=\"my-list-title\">面向供应链领域的区块链系统架构设计方法和支持技术（南大）</h3><ul class=\"my-list\"><li>论文11篇，专利5项</li><li>针对跨链技术解决方案的调研研究</li><li>基于中继的异构多链桥接融合机制的扩展方法与插件实现</li><li>领域驱动设计模式DDDP及方法研究</li><li>领域驱动的跨境海产品溯源区块链系统架构设计方法研究</li><li>一种智能合约的微服务框架研究</li><li>Hyperledger Fabric智能合约漏洞检测</li></ul><h3 class=\"my-list-title\">区块链安全和隐私数据保护机制（东大）</h3><ul class=\"my-list\"><li>智能合约安全，基于智能合约源码知识图谱的静态缺陷检测，基于AST分析的Go语言智能合约静态检测等，Chaincode 缺陷检测工具</li><li>隐私保护，一种基于账户混淆和金额加密的以太坊交易信息隐私保护方法，基于可信执行环境的拍卖合约隐私保护方法，基于Wecross平台的一种同台加密跨链资产置换隐私保护方法</li><li>共识安全，针对Tendermint共识协议的形式化验证，一种基于马尔可夫决策过程的PoW共识协议安全评估方法，一种基于层次量化模型的PoW共识协议安全评估方法</li></ul><h3 class=\"my-list-title\">区块链与大数据融合的高性能数据存储、管理和分析（星环）</h3><ul class=\"my-list\"><li>基于容器架构支持区块链的大数据分布式高性能存储、计算和管理技术</li><li>供应链过程数据的区块链和大数据平台结合的可信计算技术</li><li>交互式无编程可视化的大数据平台</li></ul><h3 class=\"my-list-title\">区块链与大数据融合的高性能数据存储、管理和分析（清华）</h3><ul class=\"my-list\"><li>多源数据的安全事件(风险)建模和识别技术</li><li>已发表论文7篇</li><li>获取到了部分的研究数据</li></ul><h3 class=\"my-list-title\">挪威方项目执行情况介绍（NTNU）</h3><ul class=\"my-list\"><li>博士生在参与硕士生进行系统实现</li><li>前期的跨链安全隐私的调研</li><li>跨链管理相关的功能研究</li><li>共识机制方面的改进</li><li>以太坊数据的提取和整理</li></ul></div></main></div></div>";
        ActivityPO activityPO=new ActivityPO();
        activityPO.setContent(content);
        activityPO.setPoster("http://124.222.93.55:8000/img/event3.JPG");
        activityPO.setTitle(title);
        activityPO.setTime("2022-01-13");
        activityPO.setClassify("中挪合作项目");
        activityPO.setViews(0);
        activityService.saveOrUpdate(activityPO);
    }

    @Test
    void getBriefActivityShortList() {
        List<ActivityGroupVO> res= activityService.getBriefActivityShortList();
        System.out.println(res.size());
        System.out.println(res.get(0).getItems().size());
    }
}