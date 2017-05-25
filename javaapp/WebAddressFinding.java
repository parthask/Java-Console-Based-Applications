package javaapp;

import java.util.Scanner;

public class WebAddressFinding {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
			String st= scan.next();
			String str []= st.split("http");
			System.out.println(str.length);
			for(int i=0;i<str.length;i++){
				System.out.println(str[i]);
			}
		}
	
}



/*
input:

https://www.linkedin.com/
https://www.youtube.com/
https://login.live.com/
http://www.java2s.com/Tutorial/SCJP/CatalogSCJP.html
https://web.skype.com/en/
https://github.com/parthask
http://codeforces.com/profile/partha_sarathi
https://algo.codemarshal.org/
http://code.makery.ch/library/javafx-8-tutorial/part1/
http://sumirbd.mobi/fileList/2516/new2old/1.html
https://codefights.com/fight/9T8GtjahdrKMT9pcA
https://downloads.mysql.com/archives/workbench/
https://e5.onthehub.com/WebStore/OfferingsOfMajorVersionList.aspx?pmv=769faff4-d124-e511-940e-b8ca3a5db7a1&cmi_mnuMain=bdba23cf-e05e-e011-971f-0030487d8897&ws=fc7f3044-f93e-e611-941d-b8ca3a5db7a1&vsro=8
http://www.jugbd.org/
http://www.oracle.com/technetwork/java/index.html
file:///C:/Users/PARTHASARATHI/Desktop/shuvooo/java%20pdf/JavaBasics-2007-04-25/JavaBasics/index.html
http://hellohasan.com/2016/07/15/%e0%a6%ac%e0%a6%bf%e0%a6%b6%e0%a7%8d%e0%a6%ac%e0%a6%b8%e0%a7%87%e0%a6%b0%e0%a6%be-%e0%a6%8f%e0%a6%b2%e0%a6%97%e0%a6%b0%e0%a6%bf%e0%a6%a6%e0%a6%ae-%e0%a7%a7/
https://www.udemy.com/collection/java-code-geeks/all-courses/?pmtag=UDMY10ALL&siteID=fauDoMV7FnU-S_jDVcfrIYWjuZRa7p9ehQ&LSNPUBID=fauDoMV7FnU&ordering=price-low-to-high
http://www.shafaetsplanet.com/planetcoding/?p=1500
http://hellohasan.com/2016/07/15/%E0%A6%AC%E0%A6%BF%E0%A6%B6%E0%A7%8D%E0%A6%AC%E0%A6%B8%E0%A7%87%E0%A6%B0%E0%A6%BE-%E0%A6%8F%E0%A6%B2%E0%A6%97%E0%A6%B0%E0%A6%BF%E0%A6%A6%E0%A6%AE-%E0%A7%A8/
https://free.facebook.com/notes/mythology-%E0%A6%AE%E0%A6%BF%E0%A6%A5%E0%A6%B2%E0%A6%9C%E0%A6%BF/%E0%A6%97%E0%A7%8D%E0%A6%B0%E0%A7%80%E0%A6%95-%E0%A6%AA%E0%A7%81%E0%A6%B0%E0%A6%BE%E0%A6%A3%E0%A7%87%E0%A6%B0-%E0%A6%B0%E0%A6%BE%E0%A6%A3%E0%A7%80-%E0%A6%B9%E0%A7%87%E0%A6%B0%E0%A6%BE/1687397681507354/?refid=17&_ft_=top_level_post_id.1687397681507354%3Atl_objid.1687397681507354%3Athid.1618747338372389%3A306061129499414%3A51%3A1420099200%3A1451635199%3A-1300679878506837842
https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24
http://panel.seoestore.net/affiliate.php
https://icpc.baylor.edu/private/home
http://howtodoinjava.com/best-practices/5-popular-java-development-frameworks/
http://docs.oracle.com/javase/tutorial/essential/io/fileio.html
http://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html
http://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/
http://www.freebookcentre.net/Java-Books-Download/Introduction-to-Spring-Framework-(Rod-Johnson)-PDF.html
http://www.freebookcentre.net/Java-Books-Download/Tutorials-on-Spring.html
https://academy.oracle.com/en/solutions-curriculum-full.html#javafound
http://pearsonvue.com/oracle/
http://www.jchq.net/essentials/
https://www.udacity.com/
https://www.scribd.com/doc/289949049/Ytha-Yu-Charles-Marut-Assembly-Language-Programming-Organization-of-the-IBM-PC-1992
http://www.java-samples.com/java/
https://java-hi5.blogspot.in/p/how-do-i-start-developing-javafx-mvc.html
http://www.javafxtutorials.com/the-2-ways-to-write-javafx-programs/
http://www.javafxtutorials.com/
http://code.makery.ch/library/javafx-8-tutorial/part1/
https://coderanch.com/t/324820/java/java/Interesting-topics-degree-dissertation
http://freesourcecode.net/javaprojects#.V-eTrPl97IU
http://www.cs.umb.edu/research/groups/
http://www.java2s.com/Code/Java/CatalogJava.htm
http://www.studytonight.com/java/dynamic-method-dispatch.php
http://www.quizover.com/certification
https://www.oracle.com/javaone/index.html
https://www.sololearn.com/Courses/
http://www.quizover.com/oracle-certified-professional-java-programmer-scjp-ocjp-mock-exam
http://ibcs-primax.com/education/partners/
http://education.oracle.com/pls/web_prod-plq-dad/db_pages.getpage?page_id=156
https://www7.pearsonvue.com/testtaker/registration/SelectExamConsecutivePage/ORACLE/1259049
https://www7.pearsonvue.com/testtaker/registration/CalendarAppointmentSearchPage/ORACLE/1259049
https://education.oracle.com/pls/eval-eddap-dcd/ocp_interface.pvue_reg
http://jobs.bdjobs.com/JobSearch.asp?LocationId=Sylhet
http://scjptest.com/mock-test.xhtml?execution=e4s2
http://sumirbd.mobi/
http://www.djmaza.cool/
https://www.khanacademy.org/
http://www.java2s.com/Tutorial/SCJP/CatalogSCJP.htm
http://www.mybanglamp3.com/genre/10/Sunday_Suspense.php
https://imgflip.com/images-to-gif
https://www.freelancer.ph/dashboard/
http://play.typeracer.com/?rt=trcyanomax
http://bdma.wapka.mobi/music/view/161146
https://crowdin.com/project/uridu/activity_stream
https://login.microsoftonline.com/common/oauth2/authorize?response_type=id_token&client_id=038ed4f5-da78-47bc-8176-9153c79e0edb&redirect_uri=https%3A%2F%2Fforms.office.com&state=b58e1788-e731-4dbc-be78-7c7d78c7f7f7&response_mode=form_post&msafed=0&client-request-id=af191aba-cf8a-44fe-80fe-616b17e97412&x-client-SKU=Js&x-client-Ver=1.0.7&nonce=98c712a6-82d0-47d2-9d8b-45aa43307ae1
http://www.discoverychannelasia.com/shows/the-mind-control-freaks/
http://hansadutta.com/
https://algo.codemarshal.org/contests/icpc-dhaka-2016-preli-mock
https://uva.onlinejudge.org/
https://www.hackerrank.com/domains?h_r=logo
https://vjudge.net/
http://www.neiljohan.com/java/
http://bani.com.bd/
https://allaboutbasic.com/2016/05/14/%E0%A6%95%E0%A7%8C%E0%A6%9F%E0%A6%BF%E0%A6%B2%E0%A7%8D%E0%A6%AF%E0%A6%9A%E0%A6%BE%E0%A6%A3%E0%A6%95%E0%A7%8D%E0%A6%AF%E0%A7%87%E0%A6%B0-%E0%A6%A8%E0%A7%80%E0%A6%A4%E0%A6%BF%E0%A6%B6%E0%A6%BE%E0%A6%B8/
http://www.sachalayatan.com/taxonomy/term/13696
https://www.grameenphone.com/flexi-plan/confirmation
http://computersciencemajor.org/12-tips-for-preparing-for-a-computer-science-job-interview/
https://portal.office.com/Signup?OfferId=8368ac6a-5797-4859-b2ec-4d32330277c9&dl=O365_BUSINESS
https://powerbi.microsoft.com/en-us/
https://blogs.msdn.microsoft.com/uk_faculty_connection/2015/09/03/microsofts-imagine-access-the-students-one-stop-shop-for-all-things-code/
https://msdn.microsoft.com/en-us/default.aspx
https://imagine.microsoft.com/en-US/Account/Manage
https://www.telenor.com/
https://www.linkedin.com/
https://www.efset.org/quick-english-check/take-test/#express1604/result
http://youngbangla.org/en/microsoft-intern/
http://www.techtunes.com.bd/microsoft-word/tune-id/211123
http://www.geeksforgeeks.org/java/
https://codefights.com/profile/partha_sarathi
http://addtext.com/photo/index?bgUrl=http%3A%2F%2Fwww6.addtext.ft-uc.com%2Ftmp%2FMjAxNjEwMjA%2Faddtext_com_MTEzNjA0NDM0MTk.png
https://www.hitchhq.com/
http://www.java2s.com/
http://docs.oracle.com/javafx/2/ui_controls/button.htm
http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
https://courses.edx.org/courses/course-v1:ITMOx+I2CPx+3T2016/info
https://www.cybrary.it/learningpath/entry-level-cyber-security-analyst?i=AD52303
http://subeen.com/
http://www.code4.life/
http://stackoverflow.com/email/confirm?id=5540972&e=parthalusyl%40gmail.com&code=704b8fd30440fd6d2a4e9ad82f32f3cd8482d8e703cb150cd55c11ae26923236
http://stackoverflow.com/questions/ask/advice?
http://javabeat.net/using-lambda-expressions-of-java-8-in-java-fx-event-handlers/
https://github.com/parthask
https://blogs.oracle.com/java/
https://www.eclipse.org/
http://docs.oracle.com/javase/8/javafx/layout-tutorial/builtin_layouts.htm#JFXLY102
http://docs.oracle.com/javase/8/javafx/layout-tutorial/builtin_layouts.htm
https://blogs.oracle.com/java/java-8-code-swim
http://www.oracle.com/us/technologies/java/top10-reasons-java-embedded-2247620.pdf
https://docs.oracle.com/javase/8/javafx/embedded-browser-tutorial/
https://jsoup.org/download

*/