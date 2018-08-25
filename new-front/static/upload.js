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
  let file = dt.file;

  uploadFile(file);
}

});

function uploadFile(file) {
  console.log("Uploading...");
  let url = 'http://142.93.107.12:9000/Image';
  let formData = new FormData();
  let id = document.getElementById('report-id');
  let desc = document.getElementById('img_description');

  formData.append('file', file);
  formData.append('report-id', id.value);
  formData.append('description',desc.value);

  result = fetch(url, {
        method: 'PUT',
        body: formData
      })
  .then(() => { console.log(result)})
  .catch(() => { console.log(result)});
}
