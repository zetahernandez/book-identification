BooksManager.FileDropBox = Ember.View.extend(DroppeableMixin, {
  tagName: "div",
  classNames: ["dropbox"],
  template: Ember.Handlebars.compile('<span id="droplabel">{{dropText}}</span>'),

  handleDrop: function (event) {
    var files = event.dataTransfer.files;
    this.controller.processFiles(files);
    /* document.getElementById("droplabel").innerHTML = "Processing " + file.name;

    var reader = new FileReader();

    // init the reader event handlers
    reader.onprogress = handleReaderProgress;
    reader.onloadend = handleReaderLoadEnd;

    // begin the read operation
    reader.readAsDataURL(file);*/
  }
});