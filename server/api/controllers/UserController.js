/**
 * UserController
 *
 * @description :: Server-side logic for managing Users
 * @help        :: See http://sailsjs.org/#!/documentation/concepts/Controllers
 */

module.exports = {



    /**
     * `UserController.index()`
     */
    index: function (req, res) {
	return res.json({
	    todo: 'index() is not implemented yet!'
	});
    },


    /**
     * `UserController.create()`
     */
    create: function(req, res){
	var params = req.params.all()
	User.create({
	    name: params.name,
	    password: params.password,
	    email: params.email
	}).exec(function createCB(err,created) {
	    if (err) res.send(err);
	    return res.json({ notice: 'Created user with name ' + created.name });
	});
    },


    /**
     * `UserController.show()`
     */
    show: function (req, res) {
	return res.json({
	    todo: 'show() is not implemented yet!'
	});
    },


    /**
     * `UserController.edit()`
     */
    edit: function (req, res) {
	return res.json({
	    todo: 'edit() is not implemented yet!'
	});
    },


    /**
     * `UserController.delete()`
     */
    delete: function (req, res) {
	return res.json({
	    todo: 'delete() is not implemented yet!'
	});
    }
};
