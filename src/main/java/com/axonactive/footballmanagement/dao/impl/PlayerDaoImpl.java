package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.PlayerDao;
import com.axonactive.footballmanagement.entities.TeamPlayedEntity;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.rest.request.PlayerRequest;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PlayerDaoImpl implements PlayerDao {
    @PersistenceContext(unitName = "football")
    EntityManager em;

    @Override
    public PlayerEntity getPlayerById(Long id) {
        return em.find(PlayerEntity.class, id);
    }

    @Override
    public List<PlayerEntity> getAllPlayers() {
        return em.createQuery("SELECT p FROM PlayerEntity p", PlayerEntity.class)
                .getResultList();
    }

    /**
     *
     * @param id
     * @return
     * Các trường hợp return:
     * - Null khi cầu thủ đang trong trạng thái tự do (không tồn tại leaveDate = null)
     * - Null khi cầu thủ chưa từng nằm trong bất kỳ clb nào (không tồn tại leaveDate = null)
     * - Trả về cầu thủ đang chơi ở câu lạc bộ hiện tại
     *
     */
    @Override
    public TeamPlayedEntity getCurrentTeamPlayedByPlayerId(Long id) {
        return em.createQuery("SELECT tp FROM TeamPlayedEntity tp WHERE tp.player.id=:id" +
                                " AND tp.leaveDate IS NULL",
                        TeamPlayedEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public PlayerEntity savePlayer(PlayerEntity player) {
        return em.merge(player);
    }


}
