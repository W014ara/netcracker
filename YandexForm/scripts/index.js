const selectContainer = document.querySelector(".current-option-wrapper");
const select = selectContainer.querySelector("#control-question");
const passwordHideBtn = document.querySelector("#pswd").nextElementSibling
  .childNodes[1].childNodes[3];
const passwordInput = document.querySelector("#pswd");
const contentPhone = document.querySelector(".content__phone");
const contentPhoneToggleBtnZero = document.querySelector(
  ".toggle-hasphone-zero"
);
const contentPhoneToggleBtnFirst = document.querySelector(
  ".toggle-hasphone-first"
);
const hasphoneBlock = document.querySelector(".hasphone");
const hasnophoneBlock = document.querySelector(".hasnophone");
const changeVoiceBlock = document.querySelector(".get-voice-code");
const captchaBlock = document.querySelector(".captcha-photo-block");
const registrationBtn = document.querySelector("#form-submit");
const registrationEulaCheck = document.querySelector(".form_eula-checkbox");
const inputFirstName = document.querySelector("#firstname");
const inputLastName = document.querySelector("#lastname");
const inputLogin = document.querySelector("#login");
const inputPhone = document.querySelector("#phone-number");
const inputPswdSubmit = document.querySelector("#pswd-submit");
const inputControlQuestion = document.querySelector("#question-answer");
const inputCaptchaAnswer = document.querySelector("#captcha-answer");

let hidePasswordToggle = false;
let hidePhoneToggle = false;
let voiceToggle = false;

select.value = "1";
selectContainer.dataset.content = select.value;

select.addEventListener("change", (e) => {
  selectContainer.dataset.content = e.currentTarget.value;
  const firstAnswerBlock = document.querySelector(".question-answer-wrapper");
  if (e.currentTarget.value === "custom") {
    firstAnswerBlock.childNodes[1].childNodes[1].childNodes[1].innerHTML =
      "Введите контрольный вопрос";
    firstAnswerBlock.insertAdjacentHTML(
      "afterend",
      `<div class="question-answer-wrapper">
        <div class="__headcontent">
          <div class="__headcontent__wrapper">
            <label for="question-answer-newAnswer">
            Ответ на контрольный вопрос</label>
          </div>
        </div>
      <input type="text" id="question-answer-newAnswer" />
    </div>`
    );
    const inputCustomControlQuestion = document.querySelector(
      "#question-answer-newAnswer"
    );
    inputCustomControlQuestion.addEventListener("change", (e) => {
      secondeSectionClassChange(inputCustomControlQuestion);
    });
  } else {
    firstAnswerBlock.childNodes[1].childNodes[1].childNodes[1].innerHTML =
      "Ответ на контрольный вопрос";
    if (document.querySelectorAll(".question-answer-wrapper")[1]) {
      const inputCustomControlQuestion = document.querySelector(
        "#question-answer-newAnswer"
      );
      inputCustomControlQuestion.removeEventListener("change", (e) => {
        secondeSectionClassChange(inputCustomControlQuestion);
      });
      document.querySelectorAll(".question-answer-wrapper")[1].remove();
    }
  }
});

passwordHideBtn.addEventListener("click", (e) => {
  hidePasswordToggle = !hidePasswordToggle;
  if (hidePasswordToggle) {
    passwordInput.type = "text";
    passwordHideBtn.classList.add("active");
  } else {
    passwordInput.type = "password";
    passwordHideBtn.classList.remove("active");
  }
});

contentPhoneToggleBtnZero.addEventListener("click", (e) => {
  hasphoneBlock.style.display = "none";
  hasnophoneBlock.style.display = "";
});

contentPhoneToggleBtnFirst.addEventListener("click", (e) => {
  hasphoneBlock.style.display = "";
  hasnophoneBlock.style.display = "none";
});

changeVoiceBlock.addEventListener("click", (e) => {
  voiceToggle = !voiceToggle;
  if (voiceToggle) {
    captchaBlock.classList.add("active");
    changeVoiceBlock.innerHTML = "Текстовый код";
  } else {
    captchaBlock.classList.remove("active");
    changeVoiceBlock.innerHTML = "Послушать код";
  }
});

registrationEulaCheck.addEventListener("click", (e) => {
  if (registrationEulaCheck.checked) {
    registrationBtn.classList.remove("disabled");
    registrationBtn.removeAttribute("disabled");
  } else {
    registrationBtn.classList.add("disabled");
    registrationBtn.setAttribute("disabled", "true");
  }
});

inputFirstName.addEventListener("change", (e) => {
  firstSectionClassChange(inputFirstName);
});

inputLastName.addEventListener("change", (e) => {
  firstSectionClassChange(inputLastName);
});

inputLogin.addEventListener("change", (e) => {
  firstSectionClassChange(inputLogin);
});

inputControlQuestion.addEventListener("change", (e) => {
  secondeSectionClassChange(inputControlQuestion);
});

inputCaptchaAnswer.addEventListener("change", (e) => {
  secondeSectionClassChange(inputCaptchaAnswer);
});

passwordInput.addEventListener("change", (e) => {
  if (!passwordInput.value) {
    passwordInput.classList.remove("completed");
    passwordInput.classList.add("notCompleted");
  } else {
    passwordInput.classList.remove("notCompleted");
    passwordInput.classList.add("completed");
  }
});

inputPswdSubmit.addEventListener("change", (e) => {
  if (!inputPswdSubmit.value) {
    inputPswdSubmit.classList.remove("invalidPswd");
    inputPswdSubmit.classList.remove("completed");
    inputPswdSubmit.classList.add("notCompleted");
  } else {
    if (inputPswdSubmit.value !== passwordInput.value) {
      inputPswdSubmit.classList.remove("completed");
      inputPswdSubmit.classList.remove("notCompleted");
      inputPswdSubmit.classList.add("invalidPswd");
    } else {
      inputPswdSubmit.classList.remove("invalidPswd");
      inputPswdSubmit.classList.remove("notCompleted");
      inputPswdSubmit.classList.add("completed");
    }
  }
});

inputPhone.classList.add("completed");
inputPhone.value = "+7 ";

inputPhone.addEventListener("input", (e) => {
  if (/^\+7\s\d{10}$/.test(inputPhone.value)) {
    if (!hasphoneBlock.contains(document.querySelector(".verificationPhone"))) {
      hasphoneBlock.insertAdjacentHTML(
        "beforeend",
        `<div class="verificationPhone">
                <span>Подтвердить номер</span>
            </div>`
      );
    }
  } else {
    if (hasphoneBlock.contains(document.querySelector(".verificationPhone"))) {
      hasphoneBlock.removeChild(document.querySelector(".verificationPhone"));
    }
  }
});

function firstSectionClassChange(nodeElement) {
  if (!nodeElement.value) {
    nodeElement.nextElementSibling.childNodes[1].childNodes[3].classList.remove(
      "complete"
    );
    nodeElement.classList.remove("completed");
    nodeElement.classList.add("notCompleted");
  } else {
    nodeElement.nextElementSibling.childNodes[1].childNodes[3].classList.add(
      "complete"
    );
    nodeElement.classList.remove("notCompleted");
    nodeElement.classList.add("completed");
  }
}

function secondeSectionClassChange(nodeELement) {
  if (!nodeELement.value) {
    nodeELement.parentElement.childNodes[3].classList.remove("complete");
    nodeELement.classList.remove("completed");
    nodeELement.classList.add("notCompleted");
  } else {
    nodeELement.parentElement.childNodes[3].classList.add("complete");
    nodeELement.classList.remove("notCompleted");
    nodeELement.classList.add("completed");
  }
}
