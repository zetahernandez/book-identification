define(["ember", "models/FileToUpload", "jquery"], function (Ember, FileToUpload, jQuery) {
  var UploadBooksController = Ember.ObjectController.extend({
    dropText: 'Drop Here',
    files: [],
    ignoredFiles: [],

    processFiles: function (files) {
      var _self = this;
      jQuery.each(files, function (index, file) {
        if (file.type === "application/pdf") {
          _self.get('files').pushObject(FileToUpload.create({
            index: index,
            file: file
          }));
        } else {
          _self.get('ignoredFiles').pushObject(FileToUpload.create({
            index: index,
            file: file
          }));
        }
      });
    },

    clearListFile: function () {
      this.set('files', []);
    },

    /*
      Upload File to Server
      */
    uploadToServer: function () {

      var filesLength = this.get('files').length,
        _self = this;

      jQuery.each(this.get('files'), function (index, file) {

        var formData = new FormData(),
          xhr = new XMLHttpRequest();
        //create the javascrit form to send with fileName and
        formData.append('fileName', file.get('name'));
        formData.append('file', file.get('file'));
        //create HTTP Request  

        xhr.open('POST', '/rest/volumes/upload', true);
        //onprogress listener
        xhr.upload.onprogress = function (event) {
          if (event.lengthComputable) {
            //update progress 
            file.set('uploaded', Math.round((event.loaded / event.total) * 100));
          }
        };
        //finish listener
        xhr.onload = function (event) {
          file.set('uploaded', 100);
          file.set('uuid', event.target.response);
          file.set('status', "complete");
          _self.loadVolume(file);
        };
        xhr.onabort = function (event) {
          console.log('abort:' + event);
          file.set('status', "aborted");
        };
        xhr.onerror = function (event) {
          console.log('error:' + event);
          file.set('status', "error");
        };
        //send form
        xhr.send(formData);
      });

    },
    /*
    Call to server to find ISBN, and volume
    */
    loadVolume: function (file) {
      var request = new jQuery.atmosphere.AtmosphereRequest(),
        socket = jQuery.atmosphere,
        subSocket;

      request.url = "rest/supervise/chat";
      request.contentType = "application/json";
      subSocket = socket.subscribe(request);
      subSocket.push(JSON.stringify({
        "uuid": file.get('uuid')
      }));

      request.onOpen = function (response) {
        console.log(response);
      };

      request.onReconnect = function (request, response) {
        console.log("Reconnecting");
        socket.info("Reconnecting");
      };

      request.onMessage = function (response) {
        var message = response.responseBody;
        console.log(message);
        try {
          var json = JSON.parse(message);
        } catch (e) {
          console.log('Error: ', message.data);
          return;
        }

        console.log('else');
        // var me = json.author == author;
        // var date = typeof (json.time) == 'string' ? parseInt(json.time) : json.time;
        // addMessage(json.author, json.text, me ?
        //   'blue' : 'black', new Date());

      };

      request.onError = function (response) {
        console.log(response);
      };

      //TODO:
      /*jQuery.ajax({
        url: '/rest/volumes/loadVolume',
        type: 'GET',
        dataType: 'json',
        data: {
          uuid: file.get('uuid')
        },
        complete: function (xhr, textStatus) {
          //called when complete
        },
        success: function (data, textStatus, xhr) {
          //called when successful
        },
        error: function (xhr, textStatus, errorThrown) {
          //called when there is an error
        }
      });
}*/
    }
  });

  return UploadBooksController;
});