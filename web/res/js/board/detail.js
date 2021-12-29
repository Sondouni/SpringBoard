var delElem = document.querySelector('.btnDel');
var updElem = document.querySelector('.btnUpd');
var iboardElem = document.querySelector('.iboard');
delElem.addEventListener('click',function (e){
   if(confirm('are you sure to delete?')){
       location.href = `/board/delete?iboard=${iboardElem.dataset.iboard}`;
   }
});
updElem.addEventListener('click',function (e){
    location.href=`/board/mod?iboard=${iboardElem.dataset.iboard}`;
})

