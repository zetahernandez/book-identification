BooksManager.Router.map(function () {
  this.route('categories');

  this.route("volumes", {
    path: "/volumes"
  });
  this.route("volumeInfoDetail", {
    path: "/volumes/:volume_id"
  });
  this.resource('settings', function () {
    this.route('general');
    this.route('upload');
  });
});