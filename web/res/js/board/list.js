var recordElem = document.querySelectorAll('.record');

recordElem.forEach(function (item){

    item.addEventListener('click',function (e){
        moveToDetail(`${item.dataset.iboard}`);
    });
});

function moveToDetail(iboard){
    location.href = `/board/detail?iboard=${iboard}`;
}