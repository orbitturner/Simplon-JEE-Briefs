const body = document.querySelector("body");
const modal = document.querySelector(".modal");
const modalButton = document.querySelector(".modal-button");
const closeButton = document.querySelector(".close-button");
const scrollDown = document.querySelector(".scroll-down");
let isOpened = false;

const openModal = () => {
  modal.classList.add("is-open");
  body.style.overflow = "hidden";
};

const closeModal = () => {
  modal.classList.remove("is-open");
  body.style.overflow = "initial";
  scrollDown.style.display = "";
};

var lastScrollTop = 0;

window.addEventListener("scroll", () => {
  var st = window.pageYOffset || document.documentElement.scrollTop;
  if (st > lastScrollTop){
    if (window.scrollY > window.innerHeight / 3 && !isOpened) {
      isOpened = true;
      scrollDown.style.display = "none";
      openModal();
    }
 } else {
  isOpened = false;
 }
  
});

modalButton.addEventListener("click", openModal);
closeButton.addEventListener("click", closeModal);

document.onkeydown = evt => {
  evt = evt || window.event;
  evt.keyCode === 27 ? closeModal() : false;
};