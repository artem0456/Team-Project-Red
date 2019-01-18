document.addEventListener('DOMContentLoaded', function() {
    let searchForms = document.getElementsByClassName('form-search');
    let repositoryLinks = document.getElementsByClassName('code-list-item-link-repository');
    let classLinks = document.getElementsByClassName('code-list-item-link-class');

    if( searchForms.length > 0 ) {
        for( let searchForm of searchForms ) {
            searchForm.addEventListener('submit', function () {
                document.getElementsByClassName('preloader')[0].classList.add('visible');
            });
        }
    }

    if( repositoryLinks.length > 0 ) {
        for( let repositoryLink of repositoryLinks ){
            let repositoryLinkUrl = repositoryLink.href;
            let repositoryName = repositoryLinkUrl.substr(repositoryLinkUrl.lastIndexOf('/') - repositoryLinkUrl.length + 1);
            repositoryLink.innerText = repositoryName;
        }
    }

    if( classLinks.length > 0 ) {
        for( let classLink of classLinks ){
            let classLinkUrl = classLink.href;
            let className = classLinkUrl.substr(classLinkUrl.lastIndexOf('/') - classLinkUrl.length + 1);
            classLink.innerText = className;
        }
    }
});

function getParameterByName(q) {
  var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
      results = regex.exec(location.search);
  return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

let resultParametr = getParameterByName('q');