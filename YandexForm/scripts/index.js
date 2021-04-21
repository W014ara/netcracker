const selectContainer = document.querySelector(".current-option-wrapper");
const select = selectContainer.querySelector("#control-question");
const passwordHideBtn = document.querySelectorAll(".markstatus")[2];
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
    console.log(registrationBtn);
    if(registrationEulaCheck.checked){
        registrationBtn.classList.remove("disabled");
        registrationBtn.removeAttribute("disabled");
    }else{
        registrationBtn.classList.add("disabled");
        registrationBtn.setAttribute("disabled","true");
    }
})

