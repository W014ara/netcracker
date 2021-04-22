const selectContainer = document.querySelector(".current-option-wrapper");
const select = selectContainer.querySelector("#control-question");
const passwordHideBtn = document.querySelector("#pswd").nextElementSibling.childNodes[1].childNodes[3];
const passwordInput = document.querySelector("#pswd");
const contentPhone = document.querySelector(".content__phone");
const contentPhoneToggleBtnZero = document.querySelector(".toggle-hasphone-zero");
const contentPhoneToggleBtnFirst = document.querySelector(".toggle-hasphone-first");
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
});

passwordHideBtn.addEventListener("click", (e) => {
    hidePasswordToggle = !hidePasswordToggle;
    if(hidePasswordToggle){
        passwordInput.type = "text";
        passwordHideBtn.classList.add("active");
    }else{
        passwordInput.type = "password";
        passwordHideBtn.classList.remove("active");
    }
})

contentPhoneToggleBtnZero.addEventListener("click", (e) => {
    hasphoneBlock.style.display = "none";
    hasnophoneBlock.style.display = "";
})

contentPhoneToggleBtnFirst.addEventListener("click", (e) => {
    hasphoneBlock.style.display = "";
    hasnophoneBlock.style.display = "none";
})

changeVoiceBlock.addEventListener("click", (e) => {
    voiceToggle = !voiceToggle;
    if(voiceToggle){
        captchaBlock.classList.add("active");
        changeVoiceBlock.innerHTML = "Текстовый код";
    }else{
        captchaBlock.classList.remove("active");
        changeVoiceBlock.innerHTML = "Послушать код";
    }
})

registrationEulaCheck.addEventListener("click", (e)=>{
    if(registrationEulaCheck.checked){
        registrationBtn.classList.remove("disabled");
        registrationBtn.removeAttribute("disabled");
    }else{
        registrationBtn.classList.add("disabled");
        registrationBtn.setAttribute("disabled","true");
    }
})


inputFirstName.addEventListener("change", (e) => {
    if(!inputFirstName.value){
        inputFirstName.nextElementSibling.childNodes[1].childNodes[3].classList.remove("complete");
        inputFirstName.classList.remove("completed");
        inputFirstName.classList.add("notCompleted");
    }else{
        inputFirstName.nextElementSibling.childNodes[1].childNodes[3].classList.add("complete");
        inputFirstName.classList.remove("notCompleted");
        inputFirstName.classList.add("completed");
    }
})

inputLastName.addEventListener("change", (e) => {
    if(!inputLastName.value){
        inputLastName.nextElementSibling.childNodes[1].childNodes[3].classList.remove("complete");
        inputLastName.classList.remove("completed");
        inputLastName.classList.add("notCompleted");
    }else{
        inputLastName.nextElementSibling.childNodes[1].childNodes[3].classList.add("complete");
        inputLastName.classList.remove("notCompleted");
        inputLastName.classList.add("completed");
    }
})

inputLogin.addEventListener("change", (e) => {
    if(!inputLogin.value){
        inputLogin.nextElementSibling.childNodes[1].childNodes[3].classList.remove("complete");
        inputLogin.classList.remove("completed");
        inputLogin.classList.add("notCompleted");
    }else{
        inputLogin.nextElementSibling.childNodes[1].childNodes[3].classList.add("complete");
        inputLogin.classList.remove("notCompleted");
        inputLogin.classList.add("completed");
    }
})

inputControlQuestion.addEventListener("change", (e) => {
    if(!inputControlQuestion.value){
        inputControlQuestion.parentElement.childNodes[3].classList.remove("complete");
        inputControlQuestion.classList.remove("completed");
        inputControlQuestion.classList.add("notCompleted");
    }else{
        inputControlQuestion.parentElement.childNodes[3].classList.add("complete");
        inputControlQuestion.classList.remove("notCompleted");
        inputControlQuestion.classList.add("completed");
    }
})

inputCaptchaAnswer.addEventListener("change", (e) => {
    if(!inputCaptchaAnswer.value){
        inputCaptchaAnswer.parentElement.childNodes[3].classList.remove("complete");
        inputCaptchaAnswer.classList.remove("completed");
        inputCaptchaAnswer.classList.add("notCompleted");
    }else{
        inputCaptchaAnswer.parentElement.childNodes[3].classList.add("complete");
        inputCaptchaAnswer.classList.remove("notCompleted");
        inputCaptchaAnswer.classList.add("completed");
    }
})

passwordInput.addEventListener("change", (e) => {
    if(!passwordInput.value){
        passwordInput.classList.remove("completed");
        passwordInput.classList.add("notCompleted");
    }else{
        passwordInput.classList.remove("notCompleted");
        passwordInput.classList.add("completed");
    }
})


inputPswdSubmit.addEventListener("change", (e) => {
    if(!inputPswdSubmit.value){
        inputPswdSubmit.classList.remove("invalidPswd");
        inputPswdSubmit.classList.remove("completed");
        inputPswdSubmit.classList.add("notCompleted");
    }
    else{
        if(inputPswdSubmit.value !== passwordInput.value){
            inputPswdSubmit.classList.remove("completed");
            inputPswdSubmit.classList.remove("notCompleted");
            inputPswdSubmit.classList.add("invalidPswd");
        }else{
            inputPswdSubmit.classList.remove("invalidPswd");
            inputPswdSubmit.classList.remove("notCompleted");
            inputPswdSubmit.classList.add("completed");
        }
    }
})

inputPhone.classList.add("completed");
inputPhone.value = "+7 ";

inputPhone.addEventListener("input", (e) => {
    if(/^\+7\s\d{10}$/.test(inputPhone.value)){
        if(!hasphoneBlock.contains(document.querySelector(".verificationPhone"))){
            hasphoneBlock.insertAdjacentHTML("beforeend",
            `<div class="verificationPhone">
                <span>Подтвердить номер</span>
            </div>`)
        }
    }else{
        if(hasphoneBlock.contains(document.querySelector(".verificationPhone"))){
            hasphoneBlock.removeChild(document.querySelector(".verificationPhone"));
        }
    }
})

