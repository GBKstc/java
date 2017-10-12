/* jshint indent: 2 */

module.exports = function(sequelize, DataTypes) {
  return sequelize.define('dining_statistics', {
    id: {
      type: DataTypes.INTEGER(10),
      allowNull: false,
      primaryKey: true,
      autoIncrement: true
    },
    date: {
      type: DataTypes.CHAR(30),
      allowNull: true
    },
    br_num: {
      type: DataTypes.INTEGER(10),
      allowNull: true
    },
    lu_num: {
      type: DataTypes.INTEGER(10),
      allowNull: true
    },
    di_num: {
      type: DataTypes.INTEGER(10),
      allowNull: true
    },
    dep_id: {
      type: DataTypes.INTEGER(10),
      allowNull: true,
      references: {
        model: 'department',
        key: 'id'
      }
    },
    content: {
      type: DataTypes.CHAR(255),
      allowNull: true
    }
  }, {
    tableName: 'dining_statistics'
  });
};
