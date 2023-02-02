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
public class PlayerDaoImpl extends GenericDaoImpl<PlayerEntity> implements PlayerDao {
    @PersistenceContext(unitName = "football")
    EntityManager em;

    public PlayerDaoImpl() {
        super(PlayerEntity.class);
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
        try {
            return em.createQuery("SELECT tp FROM TeamPlayedEntity tp WHERE tp.player.id=:id" +
                                    " AND tp.leaveDate IS NULL",
                            TeamPlayedEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }
        catch (NoResultException noResultException) {
            return null;
        }
    }

}
