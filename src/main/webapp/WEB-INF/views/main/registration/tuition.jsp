<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/head.jsp"%>
<%@ include file="../header.jsp"%>
<div class="row body mt-3">
	<!-- Body 부분 입니다. 왼쪽 메뉴, 메인 컨텐츠 부분 넣어주세요. -->
	<%@ include file="left.jsp"%>
	 <div class="col-10">
                <div class="row">
                    <div class="col-12 subTitle mb-5"><h4>등록금 납부안내</h4></div>
                    <div class="col-2"></div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">등록</h3></div>
                    <div class="col-12 mb-5">매 학기별 지정된 기간내에 등록금을 납부함으로써 학생의 신분을 유지한다.</div>
                    <div class="col-12 secondTitle mb-3"><h4 class="socialH4">등록기간</h4></div>
                    <div class="col-12 mb-5"><ul>
                        <li><em class="em_red">1학기</em>- 2월 중</li>
                        <li><em class="em_red">1학기</em>- 8월 중</li>
                        </ul>       
                    </div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">고지서 출력</h3></div>
                    <div class="col-12 mb-5">종합정보시스템 로그인후 → 등록 → 등록금고지서 출력</div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">절차 및 방법</h3></div>
                    <div class="col-2 d-none d-xl-block"></div>
                    <div class="col-12 mb-5 col-xl-8">
                        <table class="table">
                            <colgroup>
                                <col style="width:20%;">
                                <col>
                            </colgroup>
                            <thead>
                                <tr>
                                    <th scope="col"  class="tutionTableCol" style="background: #fafafa; border-right: 1px solid #c7c7c7">구 분</th>
                                    <th scope="col" class="tutionTableCol" style="background: #fafafa;">절차 및 방법</th>
                                </tr>
                            </thead>
                            <tbody class="tutionText_left">
                                <tr>
                                    <th scope="row" class="tutionText_center">신입생</th>
                                    <td>입학처 입학관리팀에서 신입학 허가를 받은 후 합격증 및 등록금 고지서를 홈페이지에서 출력하여 지정은행에 부여된 가상계좌로 납부 한다.</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="tutionText_center">편입생</th>
                                    <td>교무처 입학관리팀에서 편입학 허가를 받은 후 합격증 및 등록금 고지서를 홈페이지에서 출력하여 지정은행에 부여된 가상계좌로 납부 한다.</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="tutionText_center">재학생</th>
                                    <td>등록금 고지서를 종합정보시스템에서 출력하여 지정은행에 부여된 가상계좌로 납부 한다.</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="tutionText_center">복학생</th>
                                    <td>복학신청 한 후 등록기간에 종합정보시스템에서 등록금 고지서를 출력하여 지정은행에 부여된 가상계좌로 납부 한다.</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="tutionText_center">재입학생</th>
                                    <td>교무처 학사지원팀에서 재입학 허가를 받은 후 종합정보시스템에서 등록금 고지서를 출력하여 지정은행에 부여된 가상계좌로 납부 한다.</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="tutionText_center">전과한 학생</th>
                                    <td>교무처 학사지원팀에서 전과확정 후 종합정보시스템에서 고지서를 출력하여 지정은행에 부여된 가상계좌로 납부 한다. 기 납부한 학생중 차액이 발생한 경우 경리팀에 반환 신청한다.</td>
                                </tr>
                                <tr>
                                    <th scope="row" class="tutionText_center">재수강</th>
                                    <td>교무처 학사지원팀에서 재수강 확정후 종합정보시스템에서 등록금 고지서를 출력하여 지정은행에 부여된 가상계좌로 납부 한다.</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">등록금 분할납부 안내</h3></div>
                    <div class="col-12 mb-5"><ul>
                        <li>2월초, 8월초 학교 홈페이지에 공고</li>
                        <li>분할납부 신청은 2월, 8월 초순에 홈페이지 종합정보서비스를 이용하여 분할납부 신청</li>
                        <li>분할납부는 등록금을 4회로 나누어 납부
                            <ul><li><em class="em_red">1학기</em> - 2월, 3월, 4월, 5월에 납부</li>
                                <li><em class="em_red">2학기</em> -  8월, 9월, 10월, 11월에 납부</li>
                            </ul>
                        </li>
                        </ul>       
                    </div>
                </div>
            </div>
</div>
<%@ include file="../footer.jsp"%>