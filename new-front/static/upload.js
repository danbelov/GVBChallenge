window.addEventListener('load', function() {

let dropArea = document.getElementById('drop-area');

  ['dragenter', 'dragover', 'dragleave', 'drop'].forEach(eventName => {
    dropArea.addEventListener(eventName, preventDefaults, false)
  });

  ['dragenter', 'dragover'].forEach(eventName => {
  dropArea.addEventListener(eventName, highlight, false)
  });

 ['dragleave', 'drop'].forEach(eventName => {
  dropArea.addEventListener(eventName, unhighlight, false)
 });

function highlight(e) {
  dropArea.classList.add('highlight');
}

function unhighlight(e) {
  dropArea.classList.remove('highlight');
}

function preventDefaults (e) {
    e.preventDefault();
    e.stopPropagation();
  }

dropArea.addEventListener('drop', handleDrop, false);

function handleDrop(e) {
  let dt = e.dataTransfer;
  let files = dt.files;

  handleFile(files);
}

});

function previewFile(files) {
  let reader = new FileReader();
  reader.readAsDataURL(files[0]);
  reader.onloadend = function() {
    let img = document.createElement('img');
    img.src = reader.result;
    document.getElementById('gallery').appendChild(img);
  }
}


function handleFile(files) {
  previewFile(files);
  uploadFile(files[0]);
}


function uploadFile(file, i) { // <- Add `i` parameter
  var url = 'http://142.93.107.12:9000/Image';
  var xhr = new XMLHttpRequest();
  var formData = new FormData();
  xhr.open('PUT', url, true);
  //xhr.setRequestHeader('Content-type','application/multipart; charset=utf-8');

  let id = document.getElementById('report-id');
  let desc = document.getElementById('img_description');

  formData.append('file', file);
  formData.append('report-id', id.value);
  formData.append('description',desc.value);

  xhr.send(formData);
}
