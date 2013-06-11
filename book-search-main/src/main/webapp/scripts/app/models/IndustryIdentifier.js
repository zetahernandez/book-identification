define(["ember", "ember_data"], function (Ember, DS) {
  var IndustryIdentifier = DS.Model.extend({
    identifier: DS.attr('string'),
    type: DS.attr('string')
  });
  return IndustryIdentifier;
});