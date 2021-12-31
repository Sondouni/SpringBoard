var delElem = document.querySelector('.btnDel');
var updElem = document.querySelector('.btnUpd');
var iboardElem = document.querySelector('.iboard');
//삭제
if(delElem){
    delElem.addEventListener('click',function (e){
        if(confirm('are you sure to delete?')){
            location.href = `/board/delete?iboard=${iboardElem.dataset.iboard}`;
        }
    });
}
//수정
if(updElem){
    updElem.addEventListener('click',function (e){
        location.href=`/board/mod?iboard=${iboardElem.dataset.iboard}`;
    })
}


