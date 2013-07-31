BooksManager.ProcessFilesView = Ember.View.extend({
  tagName: "div",
  classNames: ["ProcessFiles"],
  defaultTemplate: Ember.Handlebars.compile(processFiles)

});