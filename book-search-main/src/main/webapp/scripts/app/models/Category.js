define(["ember", "ember_data"], function (Ember, DS) {
  var Category = DS.Model.extend({
    level: DS.attr('number'),
    categoryName: DS.attr('string'), //{ key: 'thumbnailUrl' }
    parent: DS.belongsTo('BooksApp.Category'),
    subCategories: DS.hasMany('BooksApp.Category'),

    haveParent: function () {
      return this.get('parent') !== null && this.get('parent') !== undefined;
    }.property('parent'),

    leftMarginStyle: function () {
      return "margin-left:" + parseInt(this.get('level'), 10) * 10 + "px";
    }.property('level')
  });
  return Category;
});