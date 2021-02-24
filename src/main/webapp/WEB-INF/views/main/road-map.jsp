<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/head.jsp"%>
<%@ include file="header.jsp"%>
<div class="row body mt-3">
	<!-- Body 부분 입니다. 왼쪽 메뉴, 메인 컨텐츠 부분 넣어주세요. -->
	<%@ include file="left.jsp"%>
	<div class="col-10">
                <div class="row">
                    <div class="col-12 subTitle mb-5"><h4>졸업</h4></div>
                    <div class="col-2"></div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">졸업요건</h3></div>
                     <div class="col-12 mb-5"><ul>
                       <li><em class="em_red">등록</em> : 소정의 등록(4년 8학기 이상 등록)을 마친자. (단, 조기졸업자는 예외)</li>
                       <li><em class="em_red">졸업학점 취득 </em>: 교육과정에 부여된 학과의 학점을 모두 취득한 자</li>
                       <li><em class="em_red">졸업논문</em> : 졸업논문 심사에 합격한 자</li>
                       <li><em class="em_red">수료자 필수사항</em>  : 졸업학점 미달 수료생은 반드시 수업일수 1/4선이내에 학적변동을 신청하여 졸업대상자로서 심사 할 수 있다. (2018.2월 이전 학점미달 수료자만 해당)</li>
                       <li><em class="em_red">수료자 졸업안내 </em> <a href="/main?pageGroup=academic&type=gradutionInfo" style="border-bottom : 1px dotted black;">안내 바로가기</a></li>
                        </ul>       
                    </div>
                     <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">졸업논문</h3></div>
                    <div class="col-12 mb-5"><ul>
                        <li>졸업에 필요한 학점을 모두 취득하는 최종학기에 졸업논문을 해당학과에 제출하여 C학점(70점)이상으로 판정 받아야 한다.</li>
                        <li>교육과정의 성질상 졸업논문의 제출이 부적당한 학과에 대하여는 소정의 절차를 거쳐 졸업시험,실기발표(졸업작품, 졸업연주 등)로 대치할 수 있다.</li>
                        <li>대학장은 학과장의 제청을 받아 본교 전임교원으로 논문 지도교수를 4학년 졸업학년도 초까지 위촉하여야 한다.</li>
                        </ul>       
                    </div>
                     <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">조기졸업</h3></div>
                      <div class="col-12 mb-5">재학중 성적우수자가 6학기 또는 7학기만에 졸업에 필요한 모든 요건을 갖추면 조기졸업 할 수 있는 제도</div>
                      <div class="col-12 secondTitle mb-3"><h4 class="socialH4">조기졸업 신청 및 자격</h4></div>
                      <div class="col-12 mb-5">매학기 성적 평점 평균이 4.00이상인 자가 매학기초 15일 이내 신청할 수 있으며, 1학년 2학기초 에 하는 것을 원칙으로 하나 본인이 취득할 학점수를 감안하여 4차학기 이내에서는 학기 개시 3주일이내에서 신청할 수 있다. 단, 징계처분이나 직전학기까지 18학점 이상을수강신청 하고 미취 득 과목이 없어야 한다. (신청서 교부 및 접수처 : 교무처 학사지원팀)</div>
                       <div class="col-12 secondTitle mb-3"><h4 class="socialH4">조기졸업 자격상실</h4></div>
                       <div class="col-12 mb-5"><ul>
                        <li>이수도중 휴학하는자</li>
                        <li>이수도중 징계처분을 받은 자</li>
                        <li>이수학기 평점평균이 4.00 미달인 자</li>
                        <li>유급 경력이 있는자</li>
                        </ul>       
                    </div>
                     <div class="col-12 secondTitle mb-3"><h4 class="socialH4">조기졸업자 확정</h4></div>
                     <div class="col-12 mb-5">조기 졸업자 신청자가 졸업요건을 갖추고 성적이 매학기 4.0 이상 및 총평점, 평균 4.1 이상인 자</div>
                </div>
            </div>
</div>
<%@ include file="footer.jsp"%>