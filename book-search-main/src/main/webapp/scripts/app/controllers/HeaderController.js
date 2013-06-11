define(["ember"], function (Ember) {
    var HeaderController = Ember.ObjectController.extend({
        needs: ['searchVolume']
    });

    return HeaderController;
});