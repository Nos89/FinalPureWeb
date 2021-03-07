<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/head.jsp"%>
<%@ include file="../header.jsp"%>
<div class="row body mt-3 mx-1">
	<!-- Body 부분 입니다. 왼쪽 메뉴, 메인 컨텐츠 부분 넣어주세요. -->
	<%@ include file="../info/left.jsp"%>
	   <div class="col-10">
                <div class="row">
                    <div class="col-12 subTitle mb-5"><h4>학적증명서발급</h4></div>
                    <div class="col-2"></div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">증명서 종류</h3></div>
                    <div class="col-12 mb-5"><ul>
                        <li>국문 : 재학, 성적, 졸업, 졸업예정(8학기 등록을 마친 자), 교원자격취득예정(8학기 등록을 마친 자), 수료, 재적, 교육비 납입증명서</li>
                        <li>영문 : 재학, 성적, 졸업, 졸업예정, 재적, 수료, 휴학증명서(영문증명서를 신청할 때에는 본인의 영문 이름을 기재하여야 함)</li>
                        </ul>       
                    </div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">대학자체 인터넷증명발급(무료)</h3></div>
                    <div class="col-12 mb-5"><ul>
                        <li>주소 : <a href="/info" style="border-bottom:1px dotted black;">종합포털 바로가기</a></li>
                        <li><em class="em_red">수수료</em> : 무료</li>
                        <li>신청 시 필요한 것 : 신분증</li>
                        <li>발급방법 : 가차대학교 포탈 홈페이지 접속 - 종합정보시스템 - 학적증명 – 증명서발급 - 발급 증명서 종류와 매수 선택 - 발급(증명발급 전체가 무료입니다.)
                        </li>    
                        </ul>       
                    </div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">외부업체 인터넷증명발급(유료)</h3></div>
                    <div class="col-12 mb-5"><ul>
                        <li>주소 : <a href="http://www.certpia.com/">http://www.certpia.com/</a></li>
                        <li><em class="em_red">수수료</em> : 유료</li>
                        <li>발급방법 : 해당 홈페이지 회원가입 후 발급</li>
                        <li>단, 해외거주자에 대한 증명 발급은 해당되지 않으니 해외 거주자에 대한 증명발급 안내를 참고하시기 바랍니다
                        </li>    
                        </ul>       
                    </div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">해외 거주자에 대한 증명발급 안내</h3></div>
                    <div class="col-12 mb-5"><ul>
                        <li>메일로 접수하여 확인후 국제우편으로 발송함(제출하는 기관에서 개별 발급한 증명서가 인정이 되지 않을 경우)
                            <ul><li>본인 메일로 변경 및 요청사항을 발송하니 수시로 확인해 주시기 바랍니다</li>
                                <li>신청 메일 : 11111@gju.ac.kr</li>
                                <li>신청자 정보 : 신청인 이름(한글, 영문 - 본인의 영문 이름(증명용)을 모두 기재), 생년월일, 출신학과, 전화번호(발송 우편봉투 기재용임), 받을 주소(영어로 기재 또는 해당 국가 언어로 기재)</li>
                                <li>신청 내용 : 상세히 기재 (신청 증명서 종류(영문, 국문) 구분해서 기재, 발급 매수), 실링 처리(기본적으로 밀봉후 압인 처리함) 등</li>
                            </ul>
                        </li>
                        <li><em class="em_red">발급 수수료 : 유료(회신 우편요금)</em><ul>
                            <li style="list-style: none;">※ 신청 내용 및 중량에 따라 회신 우편요금이 상이하니 추후 메일로 입금계좌 및 우편요금 안내함<br>
                                ※ 우편요금 입금 확인후 국제우편으로 발송처리 함<br>
                                ※ 문의전화 : 043-229-8029</li>
                            </ul>
                        </li>    
                        </ul>       
                    </div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">팩스민원을 통한 증명 발급</h3></div>
                    <div class="col-12 mb-5"><ul>
                        <li>장소 : 전국 지방행정관청 민원실(시.도, 군.구, 읍.면.동) 방문 </li>
                        <li><em class="em_red">수수료 : 유료(대행수수료 납부, 신청장소에서 납부)</em></li>
                        <li>발급방법 : 주민센터(동사무소) 민원실 방문 후 직접 수령</li>   
                        </ul>  
                        ※팩스민원의 경우 2019년 4월 15일 월요일부터 건당 1,000원의 수수료 발생함     
                    </div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">민원우편신청</h3></div>
                    <div class="col-12 mb-5"><ul>
                        <li>장소 : 가까운 우체국에서 신청</li>
                        <li><em class="em_red">수수료 : 유료(등기비용)</em></li>
                        <li>방법 : 학사지원팀 전화 문의(042-8282-8282)</li>   
                        </ul>  
                    </div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">GCU 학생지원관 사무실 발급
                        </h3></div>
                    <div class="col-12 mb-5"><ul>
                        <li>장소 : 청주대학교 GCU학생지원관 학사지원팀</li>
                        <li><em class="em_red">수수료 : 무료</em></li>
                        <li>발급방법 : 학사지원팀 방문</li>   
                        </ul>  
                    </div>
                </div>
            </div>
</div>
<%@ include file="../footer.jsp"%>