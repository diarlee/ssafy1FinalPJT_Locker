<template>
  <div class="calender-container">
    <div>
      <table class="Calendar">
        <thead>
          <tr class="header">
            <td @click="prevCalendar" style="cursor: pointer; border-radius: 20px;"><svg xmlns="http://www.w3.org/2000/svg" width="16"
                height="16" color="#52796f" fill="currentColor" class="bi bi-caret-left-fill" viewBox="0 0 16 16">
                <path
                  d="m3.86 8.753 5.482 4.796c.646.566 1.658.106 1.658-.753V3.204a1 1 0 0 0-1.659-.753l-5.48 4.796a1 1 0 0 0 0 1.506z" />
              </svg></td>
            <td class="yyyymm" colspan="5">
              <span id="calYear"></span>년 <span id="calMonth"></span>월
            </td>
            <td @click="nextCalendar" style="cursor: pointer; border-radius: 20px;"><svg xmlns="http://www.w3.org/2000/svg" width="16"
                height="16" color="#52796f" fill="currentColor" class="bi bi-caret-right-fill" viewBox="0 0 16 16">
                <path
                  d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z" />
              </svg></td>
          </tr>
          <tr class="days">
            <td>일</td>
            <td>월</td>
            <td>화</td>
            <td>수</td>
            <td>목</td>
            <td>금</td>
            <td>토</td>
          </tr>
        </thead>
        <tbody></tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
// import { RouterView, RouterLink } from "vue-router";
import { useArticleStore } from "@/stores/article";
import { useUsersStore } from "@/stores/users";
import axios from "axios";

const userStore = useUsersStore();
const articleId = ref(0);

onMounted(() => {
  buildCalendar();
});

let nowMonth = new Date(); // 현재 달을 페이지를 로드한 날의 달로 초기화
let today = new Date(); // 페이지를 로드한 날짜를 저장
today.setHours(0, 0, 0, 0); // 비교 편의를 위해 today의 시간을 초기화

// 달력 생성 : 해당 달에 맞춰 테이블을 만들고, 날짜를 채워 넣는다.
function buildCalendar() {
  let firstDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth(), 1); // 이번달 1일
  let lastDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, 0); // 이번달 마지막날

  let tbody_Calendar = document.querySelector(".Calendar > tbody");
  document.getElementById("calYear").innerText = nowMonth.getFullYear(); // 연도 숫자 갱신
  document.getElementById("calMonth").innerText = leftPad(
    nowMonth.getMonth() + 1
  ); // 월 숫자 갱신

  while (tbody_Calendar.rows.length > 0) {
    // 이전 출력결과가 남아있는 경우 초기화
    tbody_Calendar.deleteRow(tbody_Calendar.rows.length - 1);
  }

  let nowRow = tbody_Calendar.insertRow(); // 첫번째 행 추가

  for (let j = 0; j < firstDate.getDay(); j++) {
    // 이번달 1일의 요일만큼
    let nowColumn = nowRow.insertCell(); // 열 추가
  }

  for (
    let nowDay = firstDate;
    nowDay <= lastDate;
    nowDay.setDate(nowDay.getDate() + 1)
  ) {
    // day는 날짜를 저장하는 변수, 이번달 마지막날까지 증가시키며 반복

    let nowColumn = nowRow.insertCell(); // 새 열을 추가하고
    // 둥근 사각형 모양으로 집어넣기
    // nowColumn.innerText = leftPad(nowDay.getDate()); // 추가한 열에 날짜 입력

    const month = nowMonth.getMonth() + 1;
    let day = nowDay.getDate();
    if (day < 10) day = `0${day}`
    const date = `${nowMonth.getFullYear()}-${month}-${day}`;

    // userId와 날짜로 articleId 가져오기
    axios({
      url: "http://localhost:8080/api/article/getId",
      method: "POST",
      data: {
        userId: userStore.loginId,
        date: date,
      },
    })
      .then((response) => {
        articleId.value = response.data;
        // nowColumn.style.border = "0.5px solid";
        // nowColumn.style.borderRadius = "1rem";

        if (articleId.value == 0) {
          nowColumn.innerHTML = `<img src="src/assets/img/lock.png" overflow: hidden;>`;
        } else {
          nowColumn.style.translate = "2px";
          nowColumn.innerHTML = `<a href=article/detail/${articleId.value} ><img src="src/assets/img/unlock4.png" ></a>`;
        }
      })
      .catch((err) => {
        console.log(err);
      });

    if (nowDay.getDay() == 6) {
      // 토요일인 경우
      nowRow = tbody_Calendar.insertRow(); // 새로운 행 추가
    }

    if (nowDay < today) {
      // 지난날인 경우
      nowColumn.className = "pastDay";
    } else if (
      nowDay.getFullYear() == today.getFullYear() &&
      nowDay.getMonth() == today.getMonth() &&
      nowDay.getDate() == today.getDate()
    ) {
      // 오늘인 경우
      nowColumn.className = "today";
      nowColumn.onclick = function () {
        choiceDate(this);
      };
    } else {
      // 미래인 경우
      nowColumn.className = "futureDay";
      nowColumn.onclick = function () {
        choiceDate(this);
      };
    }
  }
}

// 이전달 버튼 클릭
function prevCalendar() {
  nowMonth = new Date(
    nowMonth.getFullYear(),
    nowMonth.getMonth() - 1,
    nowMonth.getDate()
  ); // 현재 달을 1 감소
  buildCalendar(); // 달력 다시 생성
}
// 다음달 버튼 클릭
function nextCalendar() {
  nowMonth = new Date(
    nowMonth.getFullYear(),
    nowMonth.getMonth() + 1,
    nowMonth.getDate()
  ); // 현재 달을 1 증가
  buildCalendar(); // 달력 다시 생성
}

// input값이 한자리 숫자인 경우 앞에 '0' 붙혀주는 함수
function leftPad(value) {
  if (value < 10) {
    value = "0" + value;
    return value;
  }
  return value;
}
</script>

<style scoped>
.calender-container {
  width: inherit;
  /* border: solid 1.35px #52796F; */
  border-radius: 2rem;
  display: flex;
  align-items: center;
  /* background-color: #f8f9fa; */
}

td {
  width: 50px;
  height: 50px;
  background-color: #ffffff;
}

.Calendar {
  text-align: center;
  margin: 0 auto;
}

.Calendar>thead>tr:first-child>td {
  font-weight: bold;
  height: 35px;
  /* border: 1px solid; */
}

.Calendar>thead>tr:last-child>td {
  background: #52796F;
  background: -webkit-linear-gradient(top left, #52796F 0%, #52796F 100%);
  background: -moz-linear-gradient(top left, #52796F 0%, #52796F 100%);
  background: -o-linear-gradient(top left, #52796F 0%, #52796F 100%);
  background: linear-gradient(to bottom right, #52796F 0%, #7fa199 100%);
  color: white;
  height: 30px;
}

.days {
  text-align: center;
  font-size: 13.5px;
}

/* .pastDay {
  background-color: lightgray;
}

.today {
  background-color: #ffca64;
  cursor: pointer;
}

.futureDay {
  background-color: #ffffff;
  cursor: pointer;
}
 */
</style>
