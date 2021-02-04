<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<table class="timeTable">
	<tr>
		<th>교시 / 요일</th>
		<th>월</th>
		<th>화</th>
		<th>수</th>
		<th>목</th>
		<th>금</th>
	</tr>
	<tr class="time">
		<td>1</td>
	</tr>
	<tr class="time">
		<td>2</td>
	</tr>
	<tr class="time">
		<td>3</td>
	</tr>
	<tr class="time">
		<td>4</td>
	</tr>
	<tr class="time">
		<td>5</td>
	</tr>
	<tr class="time">
		<td>6</td>
	</tr>
	<tr class="time">
		<td>7</td>
	</tr>
	<tr class="time">
		<td>8</td>
	</tr>
	<tr class="time">
		<td>9</td>
	</tr>
</table>




<script>
	$(".timeTable").css("text-align", "center");
	let testLecture = ["월_1,4_세포생물학", "화_5,8_분자생물학", "수_5,8_세포생물학", "수_1,4_분자생물학"];
	let day;
	let time;
	let title;
	
	for( let i = 0; i < testLecture.length; i++ ){
		day = testLecture[i].split("_")[0];
		time = testLecture[i].split("_")[1].split(",");
		title = testLecture[i].split("_")[2];
		if( day == "월" ){
			let lecture = $("<td></td>");
			lecture.attr("rowspan", time[1] - time[0] );
			lecture.html(title);
			$(".time").eq(time[0]-1).append(lecture);
			continue;
		}
		if( day == "화" ){
			for( let j = 0; j < 9; j++ ){
				if( $(".time").eq(j).children().length == 1 ){
					let empty = $("<td></td>");
					$(".time").eq(j).append(empty);
				}
			}
			let lecture = $("<td></td>");
			lecture.attr("rowspan", time[1] - time[0] );
			lecture.html(title);
			$(".time").eq(time[0]-1).append(lecture);
			continue;
		}
		if( day == "수" ){
			for( let j = 0; j < 9; j++ ){
				if( $(".time").eq(j).children().length <= 2 ){
					let empty = $("<td></td>");
					$(".time").eq(j).append(empty);
				}
			}
			let lecture = $("<td></td>");
			lecture.attr("rowspan", time[1] - time[0] );
			lecture.html(title);
			$(".time").eq(time[0]-1).append(lecture);
			continue;
		}
	}
	

</script>
