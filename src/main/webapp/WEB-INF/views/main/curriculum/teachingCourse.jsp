<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/head.jsp"%>
<%@ include file="../header.jsp"%>
<div class="row body mt-3">
	<!-- Body 부분 입니다. 왼쪽 메뉴, 메인 컨텐츠 부분 넣어주세요. -->
	<%@ include file="../info/left.jsp"%>
	 <div class="col-10">
                <div class="row">
                    <div class="col-12 subTitle mb-5"><h4>교직과정</h4></div>
                    <div class="col-2"></div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">교직개요</h3></div>
                    <div class="col-12 mb-5"><ul>
                        <li>교직과정은 중등학교 정교사(2급) 및 사서교사(2급)의 자격증 취득과정으로 교직과정이 설치 승인된 학과의 학생만이 승인후 이수할 수 있다.</li>
                        <li>교직과정 이수자는 소정의 교직과목 및 전공과목을 이수하고 교원자격무시험검정 절차를 거쳐 졸업시 교원자격증을 발급받는다.</li>
                        </ul>       
                    </div>
                    <div class="col-12 secondTitle mb-3"><h4>교직 설치학과 및 승인인원</h4></div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">사범대학</h3></div>
                    <div class="col-1 d-none d-xl-block"></div>
                    <div class="col-12 col-xl-9 mb-5">
                        <table class="table">
                            <thead>
                                <tr class="teachingCol">
                                    <th style="border-right: 1px solid #c7c7c7;">단과대학</th>
                                    <th style="border-right: 1px solid #c7c7c7;">자격종별</th>
                                    <th style="border-right: 1px solid #c7c7c7;">표시과목</th>
                                    <th style="border-right: 1px solid #c7c7c7;">학과명</th>
                                    <th>승인인원</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row" rowspan="2" class="teachingText">사범대학</th>
                                    <td rowspan="2" class="teachingText">중등학교 정교사(2급)</td>
                                    <td class="teachingText">국어</td>
                                    <td class="teachingText">국어교육과</td>
                                    <td >38</td>
                                </tr>
                                <tr>
                                    <td class="teachingText">수학</td>
                                    <td class="teachingText">수학교육과</td>
                                    <td>38</td>
                                </tr>
                                <tr>
                                    <th scope="row" colspan="4" class="teachingText">계</th>
                                    <td><strong>76</strong></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">비사범계 교직과정</h3></div>
                    <div class="col-1 d-none d-xl-block"></div>
                    <div class="col-12 col-xl-9 mb-5">  
                        <table class="table">
                            <thead>
                                <tr class="teachingCol">
                                    <th class="teachingText">단과대학</th>
                                    <th class="teachingText">자격종별</th>
                                    <th class="teachingText">표시과목</th>
                                    <th class="teachingText">전공명</th>
                                    <th>승인인원</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td rowspan="2" class="teachingText">인문사회대학</td>
                                    <td class="teachingText">중등학교 정교사(2급)</td>
                                    <td class="teachingText">영어</td>
                                    <td class="teachingText">영어영문학전공</td>
                                    <td>4</td>
                                </tr>
                                <tr>
                                    <td class="teachingText" style="border-bottom: 1px solid #dee2e6;">사서교사(2급)</td>
                                    <td class="teachingText" style="border-bottom: 1px solid #dee2e6;"></td>
                                    <td class="teachingText" style="border-bottom: 1px solid #dee2e6;">문헌정보학전공</td>
                                    <td style="border-bottom: 1px solid #dee2e6;">3</td>
                                </tr>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th scope="row" colspan="4" class="teachingText">계</th>
                                    <td><strong>7</strong></td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                    <div class="col-12 secondTitle mb-3"><h4>교직이수 신청 및 승인</h4></div>
                    <div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">비사범계 교직이수 신청</h3></div>
                    <div class="col-12 mb-5"><ul>
                        <li>비사범계 소속 학생의 교직과정 신청은 교직과정이 설치 승인된 전공의 승인인원 이내의 범위에서 제2학년 1학기 수강신청 전에 교직과정 이수신청서(소정서식)를 해당 전공 사무실에 제출하고 교무처에서 승인을 받아야 한다.</li>
                        <li>신청접수는 매학년도 입학정원에 따른 교육부 승인인원이 결정된 후 1학년 2학기말(12월 ~ 1월중)에 교무처 학사지원팀에서 별도 공지한다.</li>
                        </ul>       
                    </div>
                    <div class="col-1 d-none d-xl-block"></div>
                    <div class="col-12 col-xl-9 mb-5">  
                        <table class="table">
                            <thead>
                                <tr class="teachingCol">
                                    <th scope="col" rowspan="2"  class="teachingText" style="border-bottom: 1px solid black;">구분</th>
                                    <th scope="col"  class="teachingText">교직과</th>
                                    <th scope="col" colspan="2"  class="teachingText">선발 학과</th>
                                    <th scope="col" rowspan="2"  class="teachingText" style="border-bottom: 1px solid black;">합계</th>
                                </tr>
                                <tr class="teachingCol">
                                    <th scope="col"  class="teachingText" style="border-bottom: 1px solid black;">① 교직 적성 및 인성 검사</th>
                                    <th scope="col"  class="teachingText" style="border-bottom: 1px solid black;">② 성적</th>
                                    <th scope="col" style="border-bottom: 1px solid black;">③ 면접</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td  class="teachingText">배점</td>
                                    <td  class="teachingText">적격 / 부적격</td>
                                    <td  class="teachingText">80</td>
                                    <td  class="teachingText">20</td>
                                    <td>100</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
</div>
<%@ include file="../footer.jsp"%>