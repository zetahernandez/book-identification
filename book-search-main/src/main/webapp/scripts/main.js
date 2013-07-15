(function (root) {
  require(["config"], function (config) {
    requirejs.config(config);
    require(["domReady!", "App", "ember", "ember_data", "inview", "bootstrap", "spin"], function (dom, App, Ember, DS, inview, bootsrap, spin) {
      var app_name = config.app_name || "App";
      root[app_name] = App;
    });
  });
})(this);